/*

initialse result as empty
find the largest denominationtha t is smaller then v
add found denomination to result. subtract  valud of found denomintion  from v
if v becomes 0,then print result
else repeat steps 2 n 3 fo a ne value V
 */

def findmin(deno:Array[Int],v:Int):Int={


      val n = deno.length



  //intialize result as -

  var res =0
  var amt = v

 var newlist = List[Int]()


  //travers through all denomination starting from max

  for(i <- n-1 to 0 by -1){

  //  println(s"....res is $res")
    //println(s"....amt is $amt")
    //println(s"....deno(i) is ${deno(i)}")

    while(amt >= deno(i)){
      amt = amt - deno(i)
      res +=1
       newlist = newlist :+ deno(i)
    }
  }
  println(s"minimum number of denomiation $res")
  for( i<- newlist){
    println(i)
  }
  res

}

val deno= Array(1, 2, 5, 10, 20, 50, 100, 500, 1000)

findmin(deno,121)