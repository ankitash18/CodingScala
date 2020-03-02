/*

/ Prints a maximum set of activities that can be done by a single
    // person, one at a time.
    //  n   -->  Total number of activities
    //  s[] -->  An array that contains start time of all activities
    //  f[] -->  An array that contains finish time of all activities
 */


def activityselection(s:Array[Int],f:Array[Int],n:Int): Unit ={


  var i =0

  //sort the finish array

 // f.sorted

  for(j <- 1 to n-1){

    if(s(j) >= f(i)){

      println(s"j...$j")
      i =j
    }
  }
  println(s"i...$i")


}

val start=Array(1,3,0,5,8,5)
val finish =Array(2,4,6,7,9,9)

val n = start.length

activityselection(start,finish,n)

val test=Array(3,5,1,9,6)

test.sorted.reverse