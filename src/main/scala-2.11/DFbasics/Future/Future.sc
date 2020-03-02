import scala.concurrent._
import duration._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}


val f1=Future{Thread.sleep(1000);10}

val f2=f1.map(_*10)

f1.value //future has not yet been rwsolved
f1.isCompleted

f2.value
f2.isCompleted

println("still running")

Thread.sleep(1000)

f1.value
f1.isCompleted

f2.value
f2.isCompleted

val f3=Future{1/0}

Thread.sleep(1000)

f3.value




val a =1
val b=2
val c=3
val s="the answer is"


val sum=a+b+c

s"$s $sum"

val fa=Future(1)
val fb=Future{Thread.sleep(1000);2}

val fc=Future(3)

val fd=Future{Thread.sleep(500);"the answr is"}


val fres =for{
  a <- fa
  b <- fb
  c <-fc
  s <- fd
} yield{

  val sum= a+b+c
  s"$s $sum"
}

fres.isCompleted  //false
fres.value

Thread.sleep(1000)

fres.isCompleted  //ture
fres.value


//await/ready

val success =Future{2/1}

val failure =Future(1/0)

Await.ready(failure,1.second)

failure.value

failure.failed



val fr:Future[Any] =Future(10)


val fi=fr.collect{
  case i:Int => i
}


Await.ready(fi,1.second)


val f6=Future(2)

val f7=f6.andThen{
  case Success(i) if i%2==0 =>println(s"its even")

}

Await.result(f7,1.second)


f7.onComplete{

case Success(i) => println(s"its worked and anser is $i")
case Failure(ex) =>println(s"its fialed")

}