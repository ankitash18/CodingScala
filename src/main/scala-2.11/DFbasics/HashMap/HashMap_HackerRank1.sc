//3rd progam  counting triplets
//geometric progession
//a a*r a*r*r
//OR
//a/r,a,ar
//i <j < k

/* rightmap - frequency of each element in array
left map -
if m number of element is on left  side of a and n numner of element is on right sidr of a ,then
then total number of combination can be formed including a is is equal to m*n
array (1,3,3,9,9,9,27,81)
right map {1-> 1,3 -> 2,9 -> 3,27->1,81->1}
left map {1->1,3 -> 2,9 ->3,27->1}
reduce right map by 1
c1*c3
1*3 =3
    +
1*3 =3
+
2*1=2
+
2*1=2
+
2*1=2
+
3*1=3
+
1*0=0
*/
import scala.collection.mutable.{HashMap, ListBuffer}

val Arr= Array[Long](1,3,3,9,9,9,27,81)

def counttriplet(Arr:Array[Long],r:Long):Long= {


  val rightmap: HashMap[Long,Long] =HashMap.empty[Long,Long]

  val leftmap: HashMap[Long,Long] =HashMap.empty[Long,Long]

  val m =Arr.length

 for(i <- 0 to m-1){
   rightmap.put(Arr(i),rightmap.getOrElse(Arr(i),0L)+1)

 }

  //rightmap.foreach { case (key, value) => println(key + " -> " + value)
    // }

  var count:Long =0
  for(i <- 0 to m-1){

    val midterm =Arr(i)
    var c1:Long=0
    var c3:Long=0
    println(s"midterm $midterm.. ")

    rightmap.put(midterm,rightmap.getOrElse(Arr(i),0L)-1)

    if(leftmap.contains(midterm/r) && midterm % r ==0){

     // println(s"insdie c1.. ")

     c1 = leftmap(midterm/r)
     // println(s"c1 then $c1")


    }

    if(rightmap.contains(midterm * r)) {
    //  println(s"insdie c3.. ")
       c3 = rightmap(midterm * r)
   //   println(s"c3 then $c3")
    }

    count += c1*c3
    println(s"count inside $count")
    leftmap.put(midterm,leftmap.getOrElse(midterm,0L)+1)

  }
  println(s"count $count")
  count
}

counttriplet(Arr,3)


//check if string are anagram
