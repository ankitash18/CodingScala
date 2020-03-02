/*
using top down
 */

def findMinCost(array: Array[Array[Int]], row: Int, col: Int):Int = {
  val dp = Array.ofDim[Int](array.length,array.length)
  findMinCost_aux(dp, array, row, col)
  // end of method}
}


  def findMinCost_aux(dp: Array[Array[Int]], array: Array[Array[Int]], row: Int, col: Int) :Int= {
    if (row == -1 || col == -1) { // BASE CASE
      return Integer.MAX_VALUE
    }
    if (row == 0 && col == 0) { // BASE CASE: If we're at first cell (0, 0),then no need to recurse
      return array(0)(0)
    }
    if (dp(row)(col) == 0) { //If we have not solved this problem previously, only then solve it
      val minCost1 = findMinCost_aux(dp, array, row - 1, col)
      // Case#1: Get min cost if we go 'up' from current cell
      val minCost2 = findMinCost_aux(dp, array, row, col - 1)
      // Case#2: Get min cost if we go 'left' from current cell
      val minCost = Integer.min(minCost1, minCost2)
      val currentCellsCost = array(row)(col)
      dp(row)(col) = minCost + currentCellsCost
    }
    dp(row)(col)
  }

val array = Array(Array(4, 7, 8, 6, 4), Array(6, 7, 3, 9, 2), Array(3, 8, 1, 2, 4), Array(7, 1, 7, 3, 7), Array(2, 9, 8, 9, 3))

//findMinCost(array, array.length - 1, array(0).length - 1)

/*
usig bottom up
 */

def findMinCost1(array: Array[Array[Int]], row: Int, col: Int):Int = {
  val dp = Array.ofDim[Int](row+1,col+1)
  //This 2D array will store all the results. This Array has 1 extra Row and 1 extra Col
  for (i <- 0 to row) {
    dp(i)(0) = Integer.MAX_VALUE
  }
  for (i <- 0 to col) {
    dp(0)(i) = Integer.MAX_VALUE
  }

  dp(0)(1) = 0 //This is done to make sure that first comparison goes through successfully

  for (i <- 1 to row) {
    for (j <- 1 to col) {
      dp(i)(j) = Integer.min(dp(i - 1)(j), dp(i)(j - 1)) + array(i - 1)(j - 1)
    }

  }
  dp(row)(col)
}

val array1 = Array(Array(4, 7, 8, 6, 4), Array(6, 7, 3, 9, 2), Array(3, 8, 1, 2, 4), Array(7, 1, 7, 3, 7), Array(2, 9, 8, 9, 3))
findMinCost1(array1, array1.length, array1(0).length)