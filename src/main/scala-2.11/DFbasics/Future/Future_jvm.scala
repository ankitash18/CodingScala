package DFbasics.Future

import scala.concurrent.Future
import scala.util.{Failure, Success}

//important for future
//api for handling asynchronus programming - future
//fnctinal way of calcyating somethng in parallel
import scala.concurrent.ExecutionContext.Implicits.global

//executioncontext handles thread allocation of future

/**
  * Created by AShrivastava on 1/7/2020.
  */

/*

future   are a functional way of computing something in parallel or another thread
 */
object Future_jvm extends App{

  def calcualte:Int={

    Thread.sleep(2000)

    43
  }

  val afuture = Future{
    calcualte //it runs on another thread
  }

  println(afuture.value)

  println("waiting for future")

  afuture.onComplete(t => t match{
    case Success(meaningoflife) => println(s"emang of life $meaningoflife ")
    case Failure(e) => println(s"faile with $e")
  }) //called by some thread

  Thread.sleep(3000)
//global which is passed by compiler
}


