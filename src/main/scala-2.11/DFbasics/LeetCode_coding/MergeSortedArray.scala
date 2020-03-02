package DFbasics.LeetCode_coding

/**
  * Created by AShrivastava on 2/2/2020.
  * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array
  * The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
  Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

  Method 2 (O(n1 + n2) Time and O(n1 + n2) Extra Space)
The idea is to use Merge function of Merge sort.

Create an array arr3[] of size n1 + n2.
Simultaneously traverse arr1[] and arr2[].
Pick smaller of current elements in arr1[] and arr2[], copy this smaller element to next position in arr3[] and move ahead in arr3[] and the array whose element is picked.
If there are remaining elements in arr1[] or arr2[], copy them also in arr3[].

  */
object MergeSortedArray extends App{

  def mergeArray(arr1:Array[Int],arr2:Array[Int],n1:Int,n2:Int,arr3:Array[Int]):Unit ={

    var i =0
    var j=0
    var k=0

    // Traverse both array
    while( i < n1 && j < n2){

      // Check if current element of first
      // array is smaller than current element
      // of second array. If yes, store first
      // array element and increment first array
      // index. Otherwise do same with second array
      if(arr1(i) < arr2(j)) {
        arr3(k) = arr1(i)
        k += 1
        i += 1
      }
      else {
        arr3(k) = arr2(j)
        k += 1
        j += 1
      }

    }

    // Store remaining elements of first array
    while(i < n1){
      arr3(k) = arr1(i)
      k +=1
      j +=1
    }

    while( j < n2){
      arr3(k) = arr2(j)
        k +=1
        j +=1
    }




  }

 // val arr1 = Array(1, 3, 5, 7)
 // val n1: Int = arr1.length

 // val arr2 = Array(2, 4, 6, 8)
 // val n2: Int = arr2.length

//  val arr3 = new Array[Int](n1 + n2)

 // mergeArray(arr1, arr2, n1, n2, arr3)

  System.out.println("Array after merging")
 // for ( i <-0 to arr3.length-1)
 // print(arr3(i) + " ")


  //other way is to re-use the arr1
  def mergeArray1(arr1:Array[Int],arr2:Array[Int], m:Int, n:Int):Unit = {

    var i = m-1
    var j = n-1
    var k = m+n-1

    while(k >=0){
         if(j < 0 || (i >= 0 && arr1(i) > arr2(j))){
           arr1(k) = arr1(i)
           k -= 1
           i -=1
         }
      else{
           arr1(k) = arr2(j)
           k -=1
           j -=1
         }
       }
  }

  val arr1 = Array(1, 3, 5, 7)
  val n1: Int = arr1.length



}
