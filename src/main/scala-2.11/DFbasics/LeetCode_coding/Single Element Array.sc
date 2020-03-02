import scala.collection.mutable
import scala.collection.mutable.HashMap

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 Faster method - using XOR. performing XOR on same number gives 0.
 */

def singleNumber(nums: Array[Int]): Int = {

  val a = nums.reduce(_ ^ _)

  a
}

val nums =Array(2,2,1)
singleNumber(nums)

/*
using hashmp
 */

def singleNumber1(nums: Array[Int]): Int = {

  val hash:HashMap[Int,Int] = new mutable.HashMap[Int,Int]()

  for(  i <- 0 to nums.length-1){

      hash.put(nums(i),hash.getOrElse(nums(i),0)+1)

    }

    for((key,value) <- hash) {
      if (value == 1) {
       return  key
      }
    }
  return  0
  }


val nums1 =Array(2,2,5)
singleNumber1(nums1)
