import scala.io._

import java.io._

val pw = new PrintWriter(new File("C:\\Users\\AShrivastava\\Desktop\\study\\sparkrockthejvm\\RandomMatrix.txt"))

for(i <- 1 to 20){
  pw.println(Array.fill(20)(math.random).mkString(" "))

}
pw.close()


val nums ={

  val src = Source.fromFile("C:\\Users\\AShrivastava\\Desktop\\study\\sparkrockthejvm\\RandomMatrix.txt")
  val lines = src.getLines()

  val ret = lines.map(_.split(" ").map(_.toDouble)).toArray

  src.close()

  ret
}

import java.util.Scanner

val sc = new Scanner(new File("C:\\Users\\AShrivastava\\Desktop\\study\\sparkrockthejvm\\RandomMatrix.txt"))

var nums1 = List[Double]()

while(sc.hasNextDouble){

  nums1 ::= sc.nextDouble()
}
/*
for(i <- 0 to nums1.length-1) {
  println(nums1(i))

}

*/

val webpagesource = Source.fromURL("http://www.google.com")

val webpagelines = webpagesource.getLines()

println(webpagelines.count(_.contains("google")))

webpagesource.close()