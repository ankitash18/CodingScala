/*

given n,oount the number of ways to expres N as sum of1 ,3 ,and 4
 */

//top -down approach

def waysToGetN(n: Int) = {
  val dp = new Array[Int](n + 1)
  waysToGetN_TopDown(dp, n)
  //End of method}
}


  def waysToGetN_TopDown(dp: Array[Int], n: Int):Int = {
    if ((n == 0) || (n == 1) || (n == 2)) { // { }, {1}, {1,1}
      return 1
    }
    if (n == 3) return 2 // {1,1,1}, {3}
    if (dp(n) == 0) {
      val subtract1 = waysToGetN_TopDown(dp, n - 1)
      // if we subtract 1, we will be left with 'n-1'
      val subtract3 = waysToGetN_TopDown(dp, n - 3)
      // if we subtract 3, we will be left with 'n-3'
      val subtract4 = waysToGetN_TopDown(dp, n - 4) // if we subtract 4, we will be left with 'n-4'
      dp(n) = subtract1 + subtract3 + subtract4
    }
    dp(n)
  }

waysToGetN(4)

/*

using bottom up
 */

def waysToGetN1(n: Int):Int = {
  val dp = new Array[Int](n + 1)
  dp(0) = 1
  dp(1) = 1
  dp(2) = 1 // BaseCases
   dp(3) = 2
  for (i <- 4 to n) {
    dp(i) = dp(i - 1) + dp(i - 3) + dp(i - 4)
  }
  dp(n)
}
// End of }
waysToGetN1(4)