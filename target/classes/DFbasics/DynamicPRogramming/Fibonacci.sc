/*

using memoization
 */

def fibmemo(n:Int):Int ={



  val Nil = -1
  val lookup = new Array[Int](n+2)

  for(i <- 0 to n){
    lookup(i) = Nil
  }

  if(lookup(n) == Nil){

    if( n <= 1)
      lookup(n) = n
    else
      lookup(n) = fibmemo(n-1)+ fibmemo(n-2)
  }
 // println(lookup(n))
  return lookup(n)
}

fibmemo(6)

/*

using tabualtion(bottom -up)
 */

def fibtab(n:Int):Int ={


  val lookup =  Array.fill[Int](n+2)(-1)

  lookup(0)=0
  lookup(1) =1

  for( i <- 2 to n){
    lookup(i) = lookup(i-1) + lookup(i-2)
  }
  lookup(n)
}

fibtab(6)