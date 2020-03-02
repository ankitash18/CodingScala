def lcs1(s1:String,s2:String):Int={

  val m = s1.length
  val n = s2.length


  val memo = new Array[Int](n+1)

  for(i <- 1 to m){
    println(s" i is ....$i")
    var prev =0

    for( j <- 1 to n){
     // println(s"j is ....$j")
      val temp = memo(j)
     // println(s"temp is ....$temp")
      if(s1(i-1) == s2(j-1)){
      //  println(s"inside")
        memo(j) = prev+1
        println(s"memo(j) is ${memo(j)}")
      }else{
        memo(j) = Math.max(memo(j),memo(j-1))
       // println(s"memo(j) is ${memo(j)}")
      }
      prev = temp
    }
  }
  memo(n)
}
lcs1("ABCD", "ABDC")