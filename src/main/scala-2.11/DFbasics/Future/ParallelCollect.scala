package DFbasics.Future

/**
  * Created by AShrivastava on 7/15/2019.
  */
object ParallelCollect extends App {

  def fib(n:Int):Int =if(n <2) 1 else fib(n-1) +fib(n-2)

  for(i <- (30 to 15 by -1).par) {
    println(fib(i))
  }

  var i=0
  for(j <- (1 to 100000).par) {
//load from memory
    //add 1 to register
    //store i bakc to  emeory
    i+=1

  }
  println(i)
}
