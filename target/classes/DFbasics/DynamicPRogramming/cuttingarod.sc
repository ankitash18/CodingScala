def cutRod(price: Array[Int], n: Int) :Int= {
  val dp = new Array[Int](n+1)
  dp(0) = 0
  var max_val = Integer.MIN_VALUE
  // Build the table dp[] in bottom up manner and return
  // the last entry from the table

  for( i <- 1 to n){
    var max_val = Integer.MIN_VALUE
    for( j <- 0 until i) {
      //println(s"j is..${ price(j) + dp(i - j - 1)}")
      max_val = Math.max(max_val, price(j) + dp(i-j-1))
      //println(s"max_val is..$max_val")
    }
    dp(i) = max_val
  }
  println(s"..dp(n)...${dp(n)}")
  dp(n)
}

val arr = Array[Int](1,2,3,1)

cutRod(arr,arr.length)

// using recursion
//this has the time complexcity of o(n2)
def rodCut(price: Array[Int], n: Int): Int = {
  // base case
  if (n == 0) return 0
  var maxValue = Integer.MIN_VALUE
  // one by one partition the given rod of length n into
  //  two parts of length (1, n-1), (2, n-2), (3, n-3), ....
  // (n-1 , 1), (n, 0) and take maximum
for(i <- 1 to n) { // rod of length i has a cost price[i-1]
  val cost = price(i - 1) + rodCut(price, n - i)
  if (cost > maxValue) {
    maxValue = cost
  }

}

  maxValue
}

// length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };// length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

val price = Array(1, 5, 8, 9, 10, 17, 17, 20)

val rodlength =4

rodCut(price,rodlength)
