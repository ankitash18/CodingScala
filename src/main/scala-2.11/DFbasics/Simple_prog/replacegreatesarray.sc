/*

replce every elemt of array with nect greates elemtn

rray -3,4,20,6,15, 2,1,7

final array - 20,20,20,15,15,7,7,7
 */

//twe ofor loops -it wil ltake time complexity o(n2)

//linear method -using one loop -o(n)
//we strat at the end f array

def nextgretelm(arr:Array[Int]):Unit={

  val n=arr.length

  var max_from_right = arr(n-1)

  for(i <- n-2 to 0 by -1){

    if(max_from_right > arr(i))
      arr(i)= max_from_right
    else
      max_from_right = arr(i)
  }

  for( i<- 0 to arr.length-1){
    println(arr(i))
  }

}

val arr=Array(3,4,20,6,15,2,1,7)

nextgretelm(arr)