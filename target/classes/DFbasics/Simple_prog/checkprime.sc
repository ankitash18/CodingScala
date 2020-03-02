//a prime nuber has only two factor a and n

import scala.util.control.Breaks._

def checkprime(n:Int)={

   var res :Boolean=true

  for(i <- 2 to n-1 ) {

    if( n %i == 0){
       res = false

    }
}

  if (res ==false)
    println("Not a prime ")
  else
    println("prime")

}


checkprime(30)