val a =Array(4,3,1,2)


var count = 0

var temp = -99999

val length =  a.length-1



for(i <- 0 to length) {


  for ( j <- i+1 to length-1){
   // println("inside j "+a(j))
    //println("insdie j"+a(j+1))

    if(a(i) > a(j)  ) {

    //  println("insdie if")

      temp = a(i)
      a(i) = a(j)
      a(j) = temp

      count +=1
    }


  }
  println("count.."+count)

 }



for(j <- 0 to a.length-1){
//
   println("Array a(j).."+a(j))
 }





