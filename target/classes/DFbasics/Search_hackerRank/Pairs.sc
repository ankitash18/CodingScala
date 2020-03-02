
import scala.collection.mutable.HashSet
import scala.collection.mutable.HashMap

val arr =Array(1,5,3,4,2)

val k = 2

val numbers =arr.toSet

val map : HashSet[Int] = HashSet.empty[Int]

for(i <- 0 to arr.length-1){
  map.add(arr(i))

}
var paircount = 0
for( i <-0 to arr.length-1){
  println(s"here..${arr(i)}")
  println(s"here..${arr(i) -k}")
  if(map.contains(arr(i)-k)){
    paircount += 1
    println(s"paircount..$paircount")
  }
}

println(s"$paircount")

