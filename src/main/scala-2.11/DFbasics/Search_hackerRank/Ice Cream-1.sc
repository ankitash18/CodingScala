import scala.collection.mutable.HashMap
// 1st approach -
// normal brtue force - means loop tjrogh array 2 times and check thesum


def whatFlavors(cost:Array[Int],money:Int):Unit={

   val min,mix = for(i <- 0 to cost.length-1){
      for (j <- i+1 to cost.length-1){
         if(cost(j) == money - cost(i)){
           println(s"$i $j")
         }
      }

   }

}


val arr = Array(1,4,5,3,2)
whatFlavors(arr,4)

//time complexit y is -o(n2)

//approach2 - using hash table

/*
To improve our run time complexity, we need a more efficient way to check if the complement exists in the array. If the complement exists, we need to look up its index. What is the best way to maintain a mapping of each element in the array to its index? A hash table.
 It turns out we can do it in one-pass. While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table. If it exists, we have found a solution and return immediately.

 */
def twoSum(cost:Array[Int],money:Int):Unit={


  val map: HashMap[Int,Int] =HashMap.empty[Int,Int]

  for(i <-0 to cost.length-1){
    var complement = money - cost(i)

    if(map.contains(complement)){
      println(s"${map(complement)} $i")
      return
    }
    else {
      map.put(cost(i),i)
    }
  }
}

val arr1 = Array(1,4,5,3,2)
twoSum(arr1,5)