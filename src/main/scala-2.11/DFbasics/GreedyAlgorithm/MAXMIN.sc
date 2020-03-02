def maxMin(k: Int, arr: Array[Int]) :Int= {
 val arrnew = arr.sorted
  val n = arrnew.length
  var minUnfairness = Integer.MAX_VALUE
for( i <- 0 to n-k ) {
  //println(s"minUnfairness out $minUnfairness")
    if ((arrnew(i + k - 1) - arrnew(i)) < minUnfairness) {
      minUnfairness = (arrnew(i + k - 1) - arrnew(i))
     // println(s"minUnfairness $minUnfairness")
    }
  }
  minUnfairness
}

val arr =Array(1,4,7,2)
//1,1,1,2,2
maxMin(2,arr)


val mymultiarr= Array.ofDim[Int](2, 2)

mymultiarr(0)(0) = 2
mymultiarr(0)(1) = 7
mymultiarr(1)(0) = 3
mymultiarr(1)(1) = 4

//val newarr= mymultiarr.sortBy(_._1)

