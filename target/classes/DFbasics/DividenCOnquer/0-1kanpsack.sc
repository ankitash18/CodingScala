def knapsack(profits: Array[Int], weights: Array[Int], capacity: Int):Int = {
  return knapsackAux(profits, weights, capacity, 0)
  //end of method}
}


   def knapsackAux(profits: Array[Int], weights: Array[Int], capacity: Int, currentIndex: Int): Int =
  {
    if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) { //Base case
      return 0
    }
    var profit1 = 0
    if (weights(currentIndex) <= capacity) { // Taking current element
      profit1 = profits(currentIndex) + knapsackAux(profits, weights, capacity - weights(currentIndex), currentIndex + 1)
    }
    val profit2 = knapsackAux(profits, weights, capacity, currentIndex + 1) // Not taking current element
    Math.max(profit1, profit2)
  }