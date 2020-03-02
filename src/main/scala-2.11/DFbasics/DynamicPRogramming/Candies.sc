def candies(n:Int,arr:Array[Int]):Long ={


  val candies=new Array[Int](arr.length)

  candies(0)  = 1

  var sum:Long=0

  // search forward sequences
  for (i <- 1 to arr.length-1) {

    if (arr(i) > arr(i - 1)) {
      candies(i) = candies(i-1) +1
    }
    else
      candies(i)=1
  }

  //sum = candies(n-1)

  // search reverse sequences
  for (i <- 0 to arr.length-1 by -1) {
    if (arr(i) < arr(i-1))
    candies(i-1) = Math.max(candies(i-1), candies(i) + 1)
  }

 // long sum = 0;
  for (i <- 0 to candies.length-1) {
    sum += candies(i)
  }

println(s"candies ....$sum")
  sum
}

val ar = Array(1,2,2)
candies(3,ar)