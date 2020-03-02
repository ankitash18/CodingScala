package DFbasics.Future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
  * Created by AShrivastava on 7/15/2019.
  */
object Futures extends App {

  println("this if first")
val f = Future {

  println("printing in the future...")
}
  Thread.sleep(100)
  println("this if last")

  Thread.sleep(1)

  val f2=Future{

    for(i  <- 1 to 30) yield ParallelCollect.fib(i)
    //throw  new RuntimeException("bad")
  }

  //f2.foreach(println)   //non blocking call
  Thread.sleep(1)
println(f2.isCompleted)
  println(Await.result(f2,5.seconds)) //blocking call
  //f2.foreach(println)
  f2.onComplete{
    case Success(n) => println(n)
    case Failure(ex) => println("Something went wrong" + ex)

  }

  Thread.sleep(5000)

}
