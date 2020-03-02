/*
using top down
 */

def maxMoney(HouseNetWorth: Array[Int]):Int = {
  val dp = new Array[Int](HouseNetWorth.length)
  maxMoney_TopDown(dp, HouseNetWorth, 0)
}


 def maxMoney_TopDown(dp: Array[Int], HouseNetWorth: Array[Int], currentIndex: Int):Int = {
  if (currentIndex >= HouseNetWorth.length) return 0
   if(HouseNetWorth.length ==0) return 0
  if (dp(currentIndex) == 0) {
    val stealCurrent = HouseNetWorth(currentIndex) + maxMoney_TopDown(dp, HouseNetWorth, currentIndex + 2)
    val skipCurrent = maxMoney_TopDown(dp, HouseNetWorth, currentIndex + 1)
    dp(currentIndex) = Math.max(stealCurrent, skipCurrent)
  }
  dp(currentIndex)
}

val HouseNetWorth = Array(6, 7, 1, 30, 8, 2, 4)
maxMoney(HouseNetWorth)

// using DP memoization

def rob(nums:Array[Int]):Int ={

if(nums == null || nums.length == 0){
  0
}

  if(nums.length ==1){
    return nums(0)
  }

  val runningtotal = new Array[Int](nums.length)

  runningtotal(0) = nums(0)
  runningtotal(1) = math.max(nums(0),nums(1))

  for( i <- 2 to nums.length-1){
    runningtotal(i) = math.max(runningtotal(i-1),runningtotal(i-2)+ nums(i))
  }

  return runningtotal(runningtotal.length-1)
}

val HouseNetWorth1 = Array(6, 7, 1, 30, 8, 2, 4)
rob(HouseNetWorth1)
