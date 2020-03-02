import scala.collection.mutable.HashSet

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 */
//using brute force

def missingnumber(n:Array[Int]):Int ={


  val nums = n.sorted

  // Ensure that n is at the last index

  if(nums(nums.length-1) != nums.length){
    return nums.length
  }

  // Ensure that 0 is at the first index
  if(nums(0) != 0){
    return 0
  }

  // If we get here, then the missing number is on the range (0, n)
  for(i <- 1 to nums.length-1){
    val expectednum = nums(i-1) +1
    if(nums(i) != expectednum){
      return expectednum

    }
  }
  // Array was not missing any numbers
  return -1;
}

val nums =Array(0,4,6,3,5,2)

missingnumber(nums)

//using hashet

def missingnumber1(n:Array[Int]):Int ={

  val numset :HashSet[Int]  = HashSet[Int]()

  for(i <- n){
    numset.add(i)
  }

  val expectecooun = n.length+1
  for(number <- 0 until expectecooun){
    if(!numset.contains(number)){
      return  number
    }
  }

 return -1
}
val nums1 =Array(0,4,6,3,5,1)

missingnumber1(nums1)