val s ="UDDDDDUUUUU"

val ar =s.toCharArray()

// Complete the countingValleys function below.
def countingValleys(n: Int, s: String): Int = {

  val ar =s.toCharArray()
  var steps =0
  var lvl =0
  //var clvl =0
  //var dlvl =0

  //var length =

 // println("length "+(ar.length))

 for(i <- 0 to ar.length-1) {

 //  println(s" i... ${(i)}....${ar(i)}")
   //println(s" i... ${ar(i+1)}")

     if (ar(i) == 'U' ){

    //   println(s" i in loop... ${ar(i)}")
     // println(s" i+1... ${ar(i + 1)}")

       lvl +=1
       if(lvl ==0){
         steps +=1

       }
    println("lvl.."+lvl)
     }
     else if(ar(i) == 'D') {
       println(s" i ELSE in loop... ${ar(i)}")
       lvl -=1
       println(lvl)
     }
   }

  steps

}


countingValleys(11,s)

