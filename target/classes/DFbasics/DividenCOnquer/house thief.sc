/*

lines of house whcih has some valyes in it.
theif has tosteal the maximum valyues in it   .but he cant steal from adjacent house.

inpout =(6,71,30,8,2,4)

output =41
theifwil steal -7,30,4

 */

def maxMoney(HouseNetWorth: Array[Int]) :Int = {
  return maxMoneyRecursive(HouseNetWorth, 0)

}

   def maxMoneyRecursive(HouseNetWorth: Array[Int], currentIndex: Int): Int =
  {
    if (currentIndex >= HouseNetWorth.length) return 0
    val stealCurrentHouse = HouseNetWorth(currentIndex) + maxMoneyRecursive(HouseNetWorth, currentIndex + 2)
    val skipCurrentHouse = maxMoneyRecursive(HouseNetWorth, currentIndex + 1)
    Math.max(stealCurrentHouse, skipCurrentHouse)
  }

val HouseNetWorth = Array(6, 7, 1, 30, 8, 2, 4)

maxMoney(HouseNetWorth)