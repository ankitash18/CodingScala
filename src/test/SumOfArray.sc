
  def twoSum(nums: Array[Int], target: Int):  Array[Int]= {

    var first :Int = 0
    var second :Int =0
    var sum: Int = 0
     for(i <- 0 to nums.length-1) {
          for(j <-  i+1 to nums.length-1) {

          //  println("i...." + i)
           /// println("j..."+ j)

            sum = nums(i)+nums(j)
            println("sum.."+sum)
           //  println("target.."+target)
            if(sum == target){
              println("inside if")
              first = i
              second = j
              println("inside if i..." + i)
              println("inside if j..." +j)
              (i,j)
            }

          }
     }
    Array(first,second)
  }



val nums =Array(1,2,3,4,5)

val target =5

twoSum(nums,target)



