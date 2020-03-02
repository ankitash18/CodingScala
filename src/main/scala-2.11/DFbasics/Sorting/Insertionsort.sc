//inperative way

def insertionsort(arr:Array[Int]) {

for(i <- 1 until arr.length){

   val tmp =arr(i)
  println(s"i is $i")
  println(s"tmp is $tmp")
  var j = i-1
  println(s"j is $j")
  println(s" arr(j) is ${arr(j)}")
  while(j > -1 && arr(j) > tmp){
    println(s"inside while arr(j) is ${arr(j)} ")
    println(s"inside while j is ${j} ")
      arr(j+1) =arr(j)
    j -=1
  }
  println(s" afer while arr(j+1) is ${arr(j+1)}")
  //println(s" afer while arr(j) is ${arr(j)}")
  arr(j+1) =tmp

}


}

val nums =Array(2,4,1,3)
insertionsort(nums)

nums

/*

def insertionSort(xs: List[Int]): List[Int] = {
  def insert(y: Int, ys: List[Int]): List[Int] =
    ys match {
      case List() => y :: List()
      case z :: zs =>
        if (y < z) y :: z :: zs
        else z :: insert(y, zs)
    }

  xs match {
    case List() => List()
    case y :: ys => insert(y, insertionSort(ys))
  }
}
 */