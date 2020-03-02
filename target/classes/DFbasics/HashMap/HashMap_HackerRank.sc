

//1st programe ransom call


//1st solution using normal loop
//val magazine :Array[String] =Array("give","me","one","grand", "today","night")

val magazine1 :Array[String] =Array("two","times","three","is","not","four")
//val note :Array[String]=Array("give","one","grand","today")
//magazine.reverse
val note1 :Array[String]=Array("two","times","two","is","four")
val mag= magazine1.toList

mag.drop(2)


val mag1= magazine1.sorted
val not1= note1.sorted

def checkmag(magazine:Array[String],note:Array[String])={

  val l2= magazine.length
  val l1= note.length
  val mag1= magazine.sorted
  val note1= note.sorted



  println(s"l1..$l1")
  println(s"l2..$l2")
  var i =0
  var j=0
  var count =0
  while(i < l1 && j < l2){
    println(s"inside while..")

    if (note1(i)  ==mag1(j)) {
      println(s"inside if..")
      count += 1
      i +=1
    }

      j +=1

  }
  println(s"count $count..")
if (count == l1)
  println("yes")
else
  println("no")

}

checkmag(magazine1,note1)


//2nd method

import scala.collection.mutable.{HashMap, ListBuffer}
/*
def checkmag1(magazine:Array[String],note:Array[String]):Boolean= {

  val mag1= magazine.sorted
  val note1= note.sorted


val magazine_words:ListBuffer[String] = mag1.to[ListBuffer]

// val afg=  magazine_words.toList

  for(i <- 0 to note1.length-1){

   if(magazine_words.remove(i)) {
     //println("No")
     return false
   }
    else
    //println("Yes")
  return true
}
}

*/


import scala.collection.mutable.ListBuffer

val a=ListBuffer(1,2,3,4)

a.remove(2)

a

val arr: Array[Int] = Array(1, 2, 3, 4)
val buf: ListBuffer[Int] = arr.to[ListBuffer]


//2nd solution using HashMap
//val magazine :Array[String] =Array("give","me","one","grand", "today","night")
//val magazine :Array[String] =Array("two","times","three","is","not","four")
//val note: Array[String] = Array("give", "one", "grand", "today")
//val note :Array[String]=Array("two","times","two","is","four")


val magazine :Array[String] =Array("apgo","clm","w","lxkvg","mwz","elo","bg","elo","lxkvg","elo","apgo","apgo","w","elo","bg")

val note:Array[String]=Array("elo","mwz","bg","mwz","clm","w")
def checkmag1(magazine:Array[String],note:Array[String]) {

  val m = magazine.length
  val mag: HashMap[String, Int] = HashMap.empty[String, Int]

  val ran: HashMap[String, Int] = HashMap.empty[String, Int]

  //var count = 0

  for (i <- 0 to m - 1) {

    val temp = magazine(i)
   // println(mag.contains(temp))

    if (mag.contains(temp)) {
     // println(mag(temp))
      mag.put(temp, mag(temp) + 1)
    }
    else {
      mag.put(temp, 1)
    }
  }

// mag.foreach { case (key, value) => println(key + " -> " + value)
// }



  val n = note.length

  for (i <- 0 to n - 1) {

    val temp = note(i)
  //  println(ran.contains(temp))

    if (ran.contains(temp)) {
      //println(ran(temp))
      ran.put(temp, mag(temp) + 1)
    }
    else {
      ran.put(temp, 1)
    }
  }
  //ran.foreach { case (key, value) => println(key + " -> " + value)
  //}


  for((word,count) <-ran){
   if(!mag.contains(word)){
     println(s"here..")
     println("No")
     return
   }
    else{
     if(count > mag(word)){
       println(s"here1..")
       println("No")
       return

     }

   }

  }

  println("Yes")
}

checkmag1(magazine,note)

/******************************************************/
/*****************************************************/

//2nd program two strings match-

val s1="hi"
val s2="world"


val pattern ="world"
//s1.indexOf(pattern)

s1.indexOf(101)


s1.charAt(1)
s1(1)

s1.foreach(c => print(s"$c"))

def stringmatch(s1:String,s2:String) :String ={

  for (i <- 97 to 122) {

    if (s1.indexOf(i) > -1 && s2.indexOf(i) > -1) {
      println(s"here ${s1.indexOf(i)}")
      println(s"here2 ${s2.indexOf(i)}")
     // println("Yes")
      return "Yes"
    }
  }
 // println("No")
  return "No"
}

stringmatch(s1,s2)
