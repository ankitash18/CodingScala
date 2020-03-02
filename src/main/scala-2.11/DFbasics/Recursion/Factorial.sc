//imperative way

def fact(n:Int):Long={

  var i =1
  var acc = 1
  while(i < n){
    acc += i*acc
    i +=1
  }
  acc
}

//recursive way
def fact1(n:Int):Long ={

  if(n < 2) n
  else n * fact1(n-1)
}

//tail recusion
import scala.annotation.tailrec

@tailrec
def fact3(n:Int,acc:Long =1):Long={

  if (n < 2) acc
  else fact3(n-1,n*acc)
}

//using match

