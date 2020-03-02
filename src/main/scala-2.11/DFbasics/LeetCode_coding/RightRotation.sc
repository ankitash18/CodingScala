def rotate(arr:Array[Int],k:Int)={

 // val arr1=new Array[Int](arr.length)

  //Rotate the given array by n times toward right
  for(i <- 0 to k-1){

    //Stores the last element of array
    val last = arr(arr.length-1)

    //Shift element of array by one
    for(j <- (1 until (arr.length)).reverse){
      arr(j) =  arr(j-1)
    }
    //Last element of array will be added to the start of array.

    arr(0) = last

  }

  println("after rotation")
  for( i <- 0 to arr.length-1){
    println(arr(i))
  }
}

val arr1 =Array(1,2,3,4,5)

var n1 =3
rotate(arr1,n1)