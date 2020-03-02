package DFbasics.DynamicPRogramming

/**
  * Created by AShrivastava on 2/2/2020.
  */
object MaxProductArray extends App{

  def maxProduct(a: Array[Int]): Int = {
    if (a == null || a.length == 0)
      return 0
    var ans = a(0)
    var min = a(0)
    var max = a(0)
  for(i <- 1 to a.length-1){
      if (a(i) >= 0) {
        max = Math.max(a(i), max * a(i))
        min = Math.min(a(i), min * a(i))
        //ans = Math.max(ans,max)
      }
      else {
        val tmp = min
        //min=max
       // max =temp
        max = Math.max(a(i), min * a(i))
        min = Math.min(a(i), tmp * a(i))
      }
      ans = Math.max(ans, max)
    println(s"ans is..$ans")
    }
    ans
  }

  val a = Array(2,3,-2,4)
  println(maxProduct(a))


}
