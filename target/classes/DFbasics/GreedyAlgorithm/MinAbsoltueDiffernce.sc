/*

sort the array
then find the min differecne between tw consercutive number
 */

def minimudiff(arr:Array[Int]):Int = {

  println("soritng array")

  val arrnew = arr.sorted


  var diff = (arrnew(0) - arrnew(1)).abs
//  println(s"diff $diff  ")
  var sub = 0
  val n = arrnew.length
  for( i <- 0 until n-1 if i != i+1){
    println(arrnew(i))
    println(arrnew(i+1))
    sub = (arrnew(i) - arrnew(i + 1)).abs
   // println(s"sub $sub")
    if (sub < diff)
      diff = sub
  }
  diff
}

val arr =Array(3,-7,0)
minimudiff(arr)

arr.sorted