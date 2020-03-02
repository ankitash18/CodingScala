package DFbasics.DynamicPRogramming

/**
  * Created by AShrivastava on 2/2/2020.
  */
//Given an integer array nums,
// find the contiguous subarray (containing at least one number)
// which has the largest sum and return its sum.
/*
 [-2,1,-3,4,-1,2,1,-5,4]
 [-2,1,-2,4,3,5,6,1,5]

 time -O(n)
 space - O(n)

 Kadane's algorithm
 */
object MaxSubArray extends App {

  def maxSumSubArray(nums:Array[Int]):Int ={

    val table= new Array[Int](nums.length)
    var max = nums(0)
     table(0) = nums(0)

    for( i <- 1 to nums.length-1){
     // println(s"here..i...$i..${nums(i)}.....${table(i-1)}")
     // println(s"here..i...$i..${nums(i)} + ${(table(i-1))}")
      val sum = table(i-1) + nums(i)
     // println(s"sum s..$sum")
      table(i) = Math.max(nums(i),sum)
      //println(s"here..i after...${table(i)}")
       max = Math.max(max,table(i))

    }
  max
  }

  val nums =Array(-2,1,-3,4,-1,2,1,-5,4)
  println(maxSumSubArray(nums))

}
