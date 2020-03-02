import scala.collection.mutable

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

//brute force
def twoSum(nums: Array[Int], target: Int): Array[Int] = {
  var first: Int = 0
  var second: Int = 0
  var sum: Int = 0
  for (i <- 0 to nums.length - 1) {
    for (j <- i + 1 to nums.length - 1) {

      //  println("i...." + i)
      /// println("j..."+ j)

      sum = nums(i) + nums(j)
      //  println("sum.."+sum)
      //  println("target.."+target)
      if (sum == target) {
        println("inside if")
        first = i
        second = j
        (i, j)
      }

    }
  }
  Array(first, second)
}

//using hashmap

import scala.collection.mutable.HashMap

def twosumhashmap(nums: Array[Int], target: Int): Array[Int] = {

  val hash : HashMap[Int,Int] = new HashMap[Int,Int]()

  val ans= new Array[Int](2)

  for( i <- 0 to nums.length-1){

    if(hash.contains(target-nums(i))){
      ans(0) = hash(target-nums(i))
      ans(1)  = i
    }
    else{
      hash.put(nums(i),i)
    }
  }
  return  ans

}


val nums=Array(2,7,1,3)
val target =4
twosumhashmap(nums,target)

val list = List(1,"ankita")
