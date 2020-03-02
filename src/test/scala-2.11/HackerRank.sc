val a = Array(10,20,20,10,10,30,50,10,20)

val n= 9


def sockMerchant(n: Int, ar: Array[Int]): Int = {

  var pair = 0

  for (i <- 0 to a.length - 1) {

    // println(i)
    for (j <- i+1 to a.length - 1) {
      //println(s" j....${a(j)}")
      //println(s" i....${a(i)}")
      if (a(i) == a(j) && a(j) > 0) {

        pair += 1 //1
        a(i) = -1
        a(j) = -2

      }

    }
  }
 // println(pair)
  pair
}

val pair1 = sockMerchant(n,a)

/