def abbreviation(a:String,b:String):Unit={

val m  = a.length
val n = b.length

 val dp= Array.ofDim[Boolean](m+10,n+10)



  dp(0)(0) = true



  for( i <- 1 to n){
    println(s"i is ${i}")
    for( j <- 1 to m){

      println(s"j is ${j}")

      if( a(j-1) == b(i-1)){
       // println(s"here..dp(i)(j) ${dp(i)(j)}")
        dp(i)(j) = dp(i-1)(j-1)

        println(s"dp(i)(j) is ${dp(i)(j)}")
      }
      else if(a(j-1).toUpper == b(i-1)){
        dp(i)(j) = dp(i-1)(j-1) || dp(i)(j-1)
        println(s"dp(i)(j) inside elif is ${dp(i)(j)}")
      }
      else if(a(j-1).isLower){
        println(s"here dp(i)(j) ${dp(i)(j)}")
        dp(i)(j) =  dp(i)(j-1)
        //println(s"dp(i)(j)inside elif2 is ${dp(i)(j)}")
      }
    }
  }
  println(s"dp(n)(m) is ${dp(n)(m)}")
  if( dp(n)(m))
    println("Yes")
  else
    println("No")
}

abbreviation("Pi","P")