def lis(arr: Array[Int], n: Int):Int = {
  val lis = new Array[Int](n)
  var max = 0
  /* Initialize LIS values for all indexes */
for( i <- 0 to n-1){
  lis(i) = 1
  }




  /* Compute optimized LIS values in bottom up manner */
for( i <- 1 to n-1){
     for(j <- 0 to i){
       println(s"i...$i")
       println(s"j...$j")
       println(s"arr(j)...${arr(j)}")
       println(s"arr(i)...${arr(i)}")
       //println(s"lis(j)...${lis(j)}")
       //println(s" lis(i)...${ lis(i)}")
       if(arr(j) < arr(i) && lis(j) > lis(i)){
         lis(i) = lis(j)
         println(s" here lis(i)...${ lis(i)}")
       }
     }
    lis(i) += 1
}
  /* Pick maximum of all LIS values */
for( i <- 0 to n-1){
    if (max < lis(i)) {
      max = lis(i)
    }
     println(s"max is ..$max")
      }
  max
}

val arr = Array(10,22,3,25)
val n  = arr.length

lis(arr,n)