package DFbasics.DynamicPRogramming

/**
  * Created by AShrivastava on 2/2/2020.
  */

/*
The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body has mentioned this so far, I thought it's a good thing for everybody to know.

All the straight forward solution should work, but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.

Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.

 *maxCur = current maximum value

*maxSoFar = maximum value found so far
 */
object StockPrices extends App {

  def maxProfit(prices: Array[Int]): Int = {
    var maxCur = 0
    var maxSoFar = 0
   for( i <- 1 to prices.length-1){
     maxCur += prices(i) - prices(i - 1)
   //  println(s"maxCur is..${maxCur}")
      maxCur = Math.max(0, maxCur)
      maxSoFar = Math.max(maxCur, maxSoFar)
     //println(s"maxSoFar is..${maxSoFar}")
    }
    maxSoFar
  }

  val prices1 = Array(7,1,5,3,6,4)
  println(maxProfit(prices1))


  def maxProfitnormal(prices: Array[Int]): Int = {

    if (prices.length == 0) return 0
    var profit = 0
    val n = prices.length-1
    for( i <- 0 to n-1){
      if (prices(i) < prices(i + 1))
        profit += prices(i + 1) - prices(i)
    }
    profit
  }

  val prices =Array(7,1,5,3,6,4)
 //val a =  prices.sliding(2,1).toList
  println(maxProfitnormal(prices))


}

//if (prices.size < 2) 0 else prices.sliding(2,1).map(a => a(1) - a(0)).filter(_ > 0).sum
