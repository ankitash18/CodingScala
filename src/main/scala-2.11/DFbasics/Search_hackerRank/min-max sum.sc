//subarray min and max from 5 length array whre need to find f
//
//
// rom 4 elemens


/*

1) findthe min leement in array
find the max elemt in array
calculate the sum of all element in array
calculate minsum by sbtrating max from sum
calculate maxsum by subtrcting min from sum
 */
//using dynamic programing

def minmaxsum(arr:Array[Int]):Unit = {

var min =arr(0)

var max = min

var sum =min
  for(i <- 1 to arr.length-1){

    sum += arr(i)
    if(arr(i) < min) {
      min = arr(i)
    }
    if(arr(i) > max){
      max= arr(i)
    }
  }

  println((sum-min) + " "+(sum-max))
}

val arr =Array(1,2,5,4,3)

minmaxsum(arr)



//mac sub arrayof sixze k
//using brute force

def bruteforce(arr:Array[Int],k:Int):Int={
  var maxsum:Int =0

  for(i <- 0 until arr.length-k){
    var sum =0
    for( j <- i until i+k ){
      sum += arr(j)
    }
    maxsum= Math.max(sum,maxsum)

  }

  maxsum


}

//time complexity O(n*k)
val a =Array(2,1,5,1,3,2)

bruteforce(a,3)

//sliding windown apprcach


def slidingwindow(arr:Array[Int],k:Int):Int={

  var start=0
  var sum =0
  var  maxsum =0

  for(end <- 0 until arr.length){
    sum += arr(end)

    if(end >= k-1){
      maxsum = Math.max(sum,maxsum)
      sum = sum-arr(start)
      start +=1
    }
  }
  maxsum
}

val ar =Array(2,1,5,1,3,2)

slidingwindow(ar,3)


//kadane's algo

/*

initialize -

max_so_far =0
max)ending_here -0
loop for each element in array
a) max_ending_here = max_ending_here+ a(i)
b) if (max_ending_here < 0)
    max_endign_here =0
c) if(max_so_far <  max_ending_here)
 max_so_far = max_ending_here
 return max_so+far

 */


def maxsubarrary(a:Array[Int]):Int={

  var max_endgin_here =0
  var max_so_far =0

  for( i <- 0 to a.length-1){

    max_endgin_here += a(i)
    if(max_endgin_here < 0)
      max_endgin_here =0
    else if(max_so_far < max_endgin_here)
      max_so_far = max_endgin_here
  }
  max_so_far
}

val a2 =Array(-2,-3,4,-1,-2,1,5,-3)

maxsubarrary(a2)

//changes if array has all newgtive number

def maxsubarrary1(a:Array[Int]):Int={

  var max_so_far =a(0)
  var curr_max =a(0)

  for( i <- 0 to a.length-1){

    curr_max += a(i)
    curr_max = Math.max(a(i),curr_max)
    max_so_far =Math.max(max_so_far,curr_max)
  }
  max_so_far
}

val a3 =Array(-2,-3,4,-1,-2,1,5,-3)

maxsubarrary1(a3)