//val a = Array(1,2,3,4)

def sum(a :Array[Int]) :Int = {
    var sum =0
    for (i <- 0 to a.length-1) {
      sum = sum +a(i)

    }
  sum
}

val a = Array(1,2,3,4)


sum(a)



