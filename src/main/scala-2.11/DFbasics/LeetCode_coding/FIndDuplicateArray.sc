import scala.collection.mutable.HashSet

def containsDuplicate(nums: Array[Int]): Boolean = {

  for(i <- 0 to nums.length-1) {

    for (j <- i+1 to nums.length - 1) {

      if (nums(i) == nums(j)) {
        return true
      }
    }
  }
  return false
}

val nums =Array(1,2,3,1)
containsDuplicate(nums)

/*
using hashset
since hashset doesnt include duplicate
 */

def containsDuplicate1(nums: Array[Int]):Boolean = {
  val hash :HashSet[Int] = HashSet[Int]()

for( i <- 0 to nums.length-1){
    hash.add(nums(i))
  }
  if(hash.size != nums.length){
    return true
  } else
    return false
}

val nums1 =Array(1,2,3,1)
nums1.distinct
containsDuplicate1(nums1)

/*
anojther solution is to convert array to set
and check the length of both
if length are not equal ,then return true
 */

/*

def containsDuplicate(nums: Array[Int]): Boolean = nums.distinct.size != nums.size
 */