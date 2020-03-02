def plusOne(digits: Array[Int]): Array[Int] = {
  digits match {
    case nums if (Option(nums) == None || nums.length == 0) => nums
    case nums => {
      for (i <- nums.length-1 to 0 by -1) {
        if (digits(i) < 9) {
          digits(i) += 1
          return digits
        }
        digits(i) = 0
      }
      val rst = Array.fill[Int](nums.length+1)(0)
      rst(0) = 1
      rst
    }
  }
}

val nums =Array(9,8,9)
plusOne(nums)

/*
import scala.util.control.Breaks._
object Solution {
    def plusOne(digits: Array[Int]): Array[Int] = {
        var result = digits
        breakable {
            for(i <- (digits.size-1) to 0 by -1) {
                if(digits(i) != 9) {
                    result(i) += 1
                    break
                } else {
                    result(i) = 0
                    if(i == 0) {
                        // case [9] need to convert to [1,0]
                        result = Array(1) ++ result
                    }
                }
            }
        }
       result
    }
}
 */

