//top down approach

def knapsack(profits: Array[Int], weights: Array[Int], capacity: Int):Int = {
  val dp = Array.ofDim[Integer](profits.length,capacity+1)
   knapsackAux(dp, profits, weights, capacity, 0)
  //end of method}
}


  def knapsackAux(dp: Array[Array[Integer]], profits: Array[Int], weights: Array[Int], capacity: Int, currentIndex: Int): Int =
  {
    if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) { //Base case
      return 0
    }
    if (dp(currentIndex)(capacity) != null) { // if we have already solved this problem, then return the result from memory
      return dp(currentIndex)(capacity)
    }
    var profit1 = 0
    if (weights(currentIndex) <= capacity) { // Taking current element
      profit1 = profits(currentIndex) + knapsackAux(dp, profits, weights, capacity - weights(currentIndex), currentIndex + 1)
    }
    val profit2 = knapsackAux(dp, profits, weights, capacity, currentIndex + 1) // Not taking current element
    dp(currentIndex)(capacity) = Math.max(profit1, profit2)
    dp(currentIndex)(capacity)
  }

val profits = Array(31, 26, 72, 17)
val weights = Array(3, 1, 5, 2)

knapsack(profits,weights,7)

//bottom up approach
