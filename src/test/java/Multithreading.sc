
/**
  * ****************************************************************************
  *
  * Scala Concurrent Programming - Examples
  *
  * Copyright : V2 Maestros @2016
  *
  * ****************************************************************************
  */

object ConcurrentProgramming extends App {

  /*--------------------------------------------------------
            Regular Threads
  --------------------------------------------------------*/
  import scala.concurrent._

  //Simple thread run
  val simpleThread = new Thread(new Runnable {
    def run() {
      println("This is a simple thread")
    }
  })
  simpleThread.run()

  //A more elaborate example
  import java.util.concurrent.{BlockingQueue,LinkedBlockingQueue}

  //Implementing a listening queue
  class TestThread extends Runnable {

    val checkQueue : BlockingQueue[String]
    = new LinkedBlockingQueue[String]()

    def addToQueue(elem:String) : Unit = {
      checkQueue.add(elem)
    }

    def run() {

      var continue=true

      println("Starting to take from Queue")
      while ( continue ) {
        var elem=checkQueue.take()
        println("Taken from queue : " + elem
          + " at time " +  (new java.util.Date()).toString() )
        if ( elem.equals("end") ) {
          continue=false
        }
      }
      println("Completed taking from Queue")
    }

  }

  val testObject = new TestThread()
  (new Thread(testObject)).start()
  testObject.addToQueue("First add")
  Thread.sleep(1000)
  testObject.addToQueue("next element")
  Thread.sleep(2000)
  testObject.addToQueue("end")

  /*--------------------------------------------------------
            Thread Pool
  --------------------------------------------------------*/
  //Repeat with a thread pool
  import java.util.concurrent.{Executors, ExecutorService}
  val pool: ExecutorService = Executors.newFixedThreadPool(5)

  pool.execute(testObject)
  testObject.addToQueue("First add")
  Thread.sleep(1000)
  testObject.addToQueue("next element")
  Thread.sleep(2000)
  testObject.addToQueue("end")

  /*--------------------------------------------------------
            Futures
  --------------------------------------------------------*/

  //Needed to provide implicit context. Otherwise error
  import ExecutionContext.Implicits.global

  val futureVal: Future[Int] = Future {
    for (i <- 1 to 5) {
      //Sleeping inside future thread
      Thread.sleep(1000)
    }
    5
  }

  println("I am doing something else now..")
  //Wait for completion
  while (!futureVal.isCompleted) {
    println("Comp status : " + futureVal.isCompleted)
    Thread.sleep(1000)
  }
  println("Comp status : " + futureVal.isCompleted)
  println(futureVal.value.get.get)


  //Register a callback
  import scala.util.{ Success, Failure }

  val futureVal2: Future[Int] = Future {
    for (i <- 1 to 5) {
      //Sleeping inside future thread
      Thread.sleep(1000)
    }
    //throw new Exception("Simulating error")
    5
  }

  futureVal2 onComplete {
    case Success(value)  => println("This is oncomplete " + value)
    case Failure(errorT) => println("An error has occured: " + errorT.getMessage)
  }

  futureVal2 onSuccess {
    case value => println("This is onSuccess " + value)
  }

  futureVal2 onFailure {
    case error => println("This is on failure " + error.getMessage)
  }

  import scala.concurrent.duration._
  Await.result(futureVal2, 10 seconds)

  /*--------------------------------------------------------
            Promise
  --------------------------------------------------------*/

  //Promise
  val candyPromise = Promise[String]()
  val candyFuture = candyPromise.future

  //The future that provides value to the promise
  val makeCandy = Future {
    println("Making candy")
    Thread.sleep(2000)
    val candy="Special Candy"
    println("Here is your Candy : " + candy)
    candyPromise.success(candy)
    println("Continuing other work")
  }

  //The future that consumes the value
  val eatCandy = Future {

    println("Waiting for candy ")
    //Blocked here
    candyFuture.onSuccess {
      case candy => println("Got my candy : " + candy)
    }
    //Continue
  }

  //Keep the main thread alive.
  Thread.sleep(5000)
}