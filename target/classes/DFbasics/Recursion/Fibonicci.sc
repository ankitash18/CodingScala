//1,1,2,3,5,8,13,21....

def fib(n:Int):Int={
  if(n == 0) 0
  else if (n < 2) 1
  else fib(n-2)+ fib(n-1)

}

fib(5)

def loop(n:Int):Int = {
  def nth(n: Int): Int = n match {
    case 0 | 1 => n
    case _ => nth(n - 1) + nth(n - 2)
  }
  nth(n)
}

loop(5)

import scala.annotation.tailrec

 def nth1(n: Int): Long = {
  @tailrec
  def loop1(n: Int, current: Int, temp: Int): Int = n match {
    case 0 => current
    case _ => loop1(n - 1, temp, current + temp)
  }
  require(n >= 0)
  loop1(n, 0, 1)
}

nth1(5)

def fibloop(n:Int):Int ={

  if(n < 2) 1
  else{
    var (a,b) =(0,1)
    var c=a+b
    for(i <-2 until n){
      a=b
      b=c
      c=a+b
    }
    c
  }
}

fibloop(5)