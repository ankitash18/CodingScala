//using array

def mergesort(Array:Array[Int],left:Int,right:Int): Unit ={

  println(s"right is  is....$right")
  println(s"left is....$left")
  if(right > left)
    {
      println(s"right is greater then left is..")
      var  m=(right+left)/2
      println(s"m is....$m")
      println(s"calling left merge sort again")
      mergesort(Array,left,m)
      //println(s"calling right  merge sort again")
      mergesort(Array,m+1,right)
      println(s"calling merge with left,$left,right $right  && m $m")
      merge(Array,left,m,right)
      println(s"called")

    }


}


def merge(Array:Array[Int],left:Int,middle:Int,right:Int): Unit ={


  println(s"left inside main merge is $left //.")
  println(s"middle inside main merge is $middle //.")
  println(s"right inside main merge is $right //.")
 val leftTmpArray =  new Array[Int](middle-left+2)
 val  rightTmpArray = new Array[Int](right-middle+1)

  for(i <- 0 to middle-left){
    leftTmpArray(i) = Array(left + i)
  }

  for(i <- 0 to right-middle){
    rightTmpArray(i) = Array(middle + 1 + i)
  }

  leftTmpArray(middle - left + 1) = Integer.MAX_VALUE //Merge values and insert into Array 'A'

  rightTmpArray(right - middle) = Integer.MAX_VALUE


  for(i <- 0 to leftTmpArray.length -1){
    println(s"left array..${leftTmpArray(i)}")
  }

  for(i <- 0 to rightTmpArray.length -1){
    println(s"right array..${rightTmpArray(i)}")
  }



}

val array = Array(10, 3, 2, 4, 3, 1)

import org.apache.hadoop.util.MergeSort

mergesort(array, 0, array.length - 1)