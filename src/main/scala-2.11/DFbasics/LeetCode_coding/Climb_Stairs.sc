/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

using DP with memoization bottom up

Ideas:
 * Use Dynamic Programming,
 * for each step, the stair could ether combine with the previous one or as a single step.
 * Ways to climb to ith stair is W(i) = W(i-1) + W(i-2)
 * where W(i-1) is when the ith stair is as a single step
 * and W(i-2) is when the ith stair is paired with the previous one.

 */

def climbstairs(n:Int):Int={

  if(n <= 0) 0
  else if (n == 1) 1
  else if(n ==2) 2

  val dp = new Array[Int](n+2)

  dp(1) = 1
  dp(2) = 2

  for( i <- 3 to n){
    dp(i) = dp(i-1) + dp(i-2)
  }
   dp(n)
}

climbstairs(6)

//using recursion

//import scala.collection.mutable
import scala.collection.mutable.HashMap

def climbStairs(n: Int):Int = {
  val memo = new Array[Int](n + 1)
  climb_Stairs(0, n, memo)
}
def climb_Stairs(i: Int, n: Int, memo: Array[Int]):Int = {
  if (i > n) return 0
  if (i == n) return 1
  if (memo(i) > 0) return memo(i)
  memo(i) = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo)
  memo(i)
}

climbStairs(4)