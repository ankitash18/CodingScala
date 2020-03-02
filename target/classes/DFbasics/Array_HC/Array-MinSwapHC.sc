
val a =Array(4,3,1,2)

//val a=Array(3,7,6,9,1,8,10,4,2,5)

//val a =Array(2,3,4,1,5)  //right

//val a =Array(1,3,5,2,4,6,7)


//val a =Array(3,7,6,9,1,8,10,4,2,5)

val length =a.length

//var b :Array[Int] = new Array(0)(length-1)

val temp =Array.fill[Int](length)(0)


for(i <-0 to a.length-1) {
  temp(a(i) - 1) = i
}

for(i <- 0 to a.length-1) {
  //println(i)
  println(temp(i))

}

var counter = 0

for(i <-0 to a.length-1){
    if (a(i) != (i+1)) { //4 !=3
      var t = temp(i)  //t =temp(0)=2
      a(t) = a(i)  //a(2)=a(0)=4
      a(i) = i + 1    //a(0)=1
      temp(a(t) - 1) = t   //temp(a(2)-1)=temp(3) =2
      temp(i) = i  //temp(0) =0

      counter += 1
    }

}

println("counter.."+counter)




/*

for( i <- 0 to a.length-1){

  //println(a(i))

  b(i) = a(i)

  println(b(i))

}

scala.util.Sorting.quickSort(b)


for( i <- 0 to b.length-1){

  //println(a(i))
  println(b(i))
}

var j=0
for(i <- 0 to  a.length-1){
  if(a(i) > b(i)) {
    println("here")
    println("a(i)...", a(i))
    println("b(j)....", b(j))
    println("j...", j)
    j += 1
  }
}

println("finsl j....",j)

val count = (a.length -j)

println("count..."+count)

*/


/* def minimumSwaps(a: Array[Int]): Int = {

             var count =0
            var temp = -99999

            val length =  a.length-1


            for(i <- 0 to length) {


            for ( j <- i+1 to length -1 ){


                            if(a(i) > a(j)  ) {

                            //println("insdie if")

                            temp = a(i)
                            a(i) = a(j)

                            a(j) = temp

                            count +=1
                            }


                        }
                        //println("count"+count)

                }
                count


    }
    */









