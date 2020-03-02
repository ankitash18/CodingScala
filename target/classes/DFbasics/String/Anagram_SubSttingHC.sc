//making anagrams

val t = "abc"

println(t.toUpperCase())

import scala.collection.mutable.{HashMap, ListBuffer}
import scala.math.abs

val str1 = "zy"
val str2 = "xy"

var count = 0

for (i <- 97 to 123) {


  val ia = str1.count(_ == i)
  println(s"ia...$ia for i ..$i")

  val ib = str2.count(_ == i)
  println(s"ib...$ib for i ..$i")

  count += abs(ia - ib)


  //count
}
println(s"count...$count")

//alternating characters

val text = "AAABBB"

var index = -1
var j = 0
for (i <- 0 until text.length - 1) {
  println(s"i..$i")
  // println(s"jchere.. $j")
  if (text(i) == text(i + 1)) {
    println(s"j.. $j")
    j += 1
  }
  index = j
  println(s"index..$index")

}


//valid string

val s = "abbccc"
def validstring(s: String):String = {

  val str: HashMap[Char, Int] = HashMap.empty[Char, Int]
  val s1 = s.toCharArray
  val m = s1.length

  for (i <- 0 to m - 1) str.put(s1(i), str.getOrElse(s1(i),0) + 1)
  str.foreach {
    case (key, value) => println(key + " -> " + value)
  }

var onemore =1
val checkval=str(s(0)) //1

  println(checkval)

  for((key,cnt) <- str){

    println(s"cnt is $cnt")
    println(s"checkval is $checkval")
//cnt =2
    if(cnt != checkval){
      println(s"insde if ")
      if(checkval == (cnt - onemore) || (checkval == cnt + onemore) || (cnt - onemore) ==0) {
        println(s"insde another  if ")
        onemore -= 1
        println(s"onemore $onemore ")
      }
      else {
        println(s"insde else  ")
        return "NO"
      }
    }
  }

  return "YES"

}
validstring(s)

//special string again