def minsort(arr:Array[Int]){
  for(i <- 0 until arr.length-1){
    var min=i
    for(j <- i+1 until arr.length){
      if(arr(j)<arr(min)) min=j

    }
    if(min !=i){
      val tmp=arr(i)
      arr(i)=arr(min)
      arr(min)=tmp

    }


  }


}

val nums =Array(3,8,6,4,1,7)
minsort(nums)

nums