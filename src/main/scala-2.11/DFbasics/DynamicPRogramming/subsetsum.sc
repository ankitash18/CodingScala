def maxSubsetSum(arr: Array[Int]):Int = {
  var prevWith = 0
  var prevWithout = 0
 for(i <- 0 to arr.length-1){
    val oldPrevWithout = prevWithout
    prevWithout = Math.max(prevWithout, prevWith)
    prevWith = arr(i) + oldPrevWithout
  }
  Math.max(prevWithout, prevWith)
}

val arr =Array(3,5,-7,8,10)
maxSubsetSum(arr)