package Search
/**
  * Created by AShrivastava on 1/4/2020.
  */
object BinarySearch {

  def search(arr: Array[Int],x:Int): Unit = {

    val high = arr.length-1
    val low =0

    var result = binarysearch(arr,0,high,x)

    if (result == -1)
      println("Element not present")
    else
      println(s"Element found at index $result")
  }


  def binarysearch(arr:Array[Int],low:Int,high:Int,x:Int):Int={

   if(high >= low){
     var mid= low+(high-low)/2
     if(arr(mid) == x){
      return  mid
     }
     if (arr(mid) > x ){
       return  binarysearch(arr,low,mid-1,x)
     }
       else {

       return binarysearch(arr, mid + 1, high, x)
       }
     }

    return  -1

   }

}

