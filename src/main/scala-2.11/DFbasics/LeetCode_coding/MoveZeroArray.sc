/*

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */

def moveZeroes(nums: Array[Int]): Unit = {


  val n = nums.length
  var size =0
  var j =0
  for(i <- 0 to n-1 ) {
    if (nums(i) != 0) {
      nums(j) = nums(i)
      j += 1
    }
  }
 println(s"j is..$j")
while( j < n){
   nums(j) =0
   j +=1
}

  for(i <- 0 to n-1){
    println(nums(i))
  }
  //println(s"size is...$size")


}

val arr = Array(0,1,0,3,12)

moveZeroes(arr)

/*
 def moveZeroes(nums: Array[Int]): Unit = {
        var left, right = 0
        while (right < nums.length) {
            if (nums(right) != 0) {
                nums(left) = nums(right)
                left += 1
            }

            right += 1
        }

        java.util.Arrays.fill(nums, left, right, 0)
    }
 */

/*
def moveZeroes(nums: Array[Int]): Unit = {
    val count = nums.indices.foldLeft(0) {
      case (acc, e) =>
        if (nums(e) != 0) {
          nums(acc) = nums(e)
          acc + 1
        } else acc
    }
    for (i <- count until nums.length) nums(i) = 0
  }
 */