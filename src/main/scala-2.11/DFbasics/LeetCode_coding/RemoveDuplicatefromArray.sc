/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

def  removeDuplicates(nums: Array[Int]): Int ={

  val n = nums.length
  var j = 1

  if (nums.isEmpty) return 0
  if (nums.length <= 1) return nums.length

  for( i <- 1 to n-1 if j< n ) {
    if(nums(i-1) != nums(i)) {
      nums(j) = nums(i)
      j += 1
    }

  }
  for(i <- 0 to j-1 ){
    println(nums(i))
  }
  return  j

  }



//val nums =Array(1,1,2)
val nums = Array(0,0,1,1,1,2,2,3,3,4)
removeDuplicates(nums)
