def findMinCost(cost: Array[Array[Int]], row: Int, col: Int) :Int= {
  if (row == -1 || col == -1) { //BASE CASE
    return Integer.MAX_VALUE
  }
  if (row == 0 && col == 0) { //BASE CASE: If we're at first cell (0, 0),then no need to recurse
    return cost(0)(0)
  }
  val minCost1 = findMinCost(cost, row - 1, col)
  //Case#1 Get min cost if we go 'up' from current cell
  val minCost2 = findMinCost(cost, row, col - 1)
  //Case#2 Get min cost if we go 'left' from current cell
  val minCost = Integer.min(minCost1, minCost2)
  val currentCellsCost = cost(row)(col)
  minCost + currentCellsCost
  //end of method}
}

val array = Array(Array(4, 7, 8, 6, 4), Array(6, 7, 3, 9, 2), Array(3, 8, 1, 2, 4), Array(7, 1, 7, 3, 7), Array(2, 9, 8, 9, 3))


findMinCost(array, array.length - 1, array(0).length - 1)