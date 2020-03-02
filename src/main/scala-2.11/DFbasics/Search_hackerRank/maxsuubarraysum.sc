//a subaaray is array rthat uis inside another array andit shouldbe contiguous.


//kadan'se algorithm

def  maxsumsub(arr:Array[Int]):Int ={


  var maxsum =arr(0)
  var sum = arr(0)

  for(i <- 1 to arr.length-1){

    if(sum < 0)
      sum =arr(i)

    else
      sum = sum+arr(i)

    maxsum=math.max(sum,maxsum)

  }
  maxsum

}


val arr =Array(3,5,-7,8,10)

maxsumsub(arr)