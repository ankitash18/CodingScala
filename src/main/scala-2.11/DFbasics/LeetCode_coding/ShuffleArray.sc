val nums :Array[Int] = Array(1,2,3,4,5)

scala.util.Random.shuffle(nums.toList).toArray

class Solution(_nums:Array[Int]){

  //reste the array toits original

  def reset():Array[Int]={
    return _nums
  }

  //return he shufles array
  def shuffle():Array[Int]={

    scala.util.Random.

    return  scala.util.Random.shuffle(_nums.toList).toArray
  }
}

object call extends App{

  var obj = new Solution(nums)
  var param_2 = obj.shuffle()
  for(i <- 0 to param_2.length-1){
    println(param_2(i))
  }
  var paramr_1 = obj.reset()
}