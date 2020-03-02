//val nums =Array(1,2,2,1)
//val num1= Array(2,2)

//val a = nums.toSet.intersect(num1.toSet)

//a.toArray


def intersect(nums1:Array[Int],nums2:Array[Int]):Array[Int]={

  val nums3= new Array[Int] (Math.min(nums1.length,nums2.length))

  val arr1 = nums1.sorted
  val arr2= nums2.sorted
  var k = 0
  var i = 0
  var j =0

  while(i < nums1.length && j < nums2.length){

    if( arr1(i)== arr2(j)){
      nums3(k) = arr1(i)
      i+= 1
      j +=1
       k +=1

    }else if(arr1(i) < arr2(j)){
      i +=1
    } else{
        j += 1
    }

  }

nums3
}
val nums =Array(1,2,2,1)
val num1= Array(2,2)
val a = nums.intersect(num1)

a
intersect(nums,num1)

//using map
/*

import scala.collection.mutable.ListBuffer

object Solution {
    def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        var num1Map : Map[Int, Int] = nums1.groupBy(identity).mapValues(_.length)
        var r = new ListBuffer[Int]()
        nums2.foreach( n => {
          if(num1Map.contains(n) && num1Map(n) != 0){
            r += n
            num1Map = num1Map.updated(n,num1Map(n) - 1)
          }
        })
        r.toArray
    }
}
 */
