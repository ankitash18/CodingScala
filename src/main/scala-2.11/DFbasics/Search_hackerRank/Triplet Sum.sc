import scala.collection.mutable.HashSet

//val a = Array(3,5,7,7,1,1)

//a.toSet //remove duplictes

//find element in array a which are less hen array b
//find elemet kin array c which are elss then aray b

//then apply the binary search

//brute force - normal iterative o(n2)

//fist will remove the duplicate using hashset

def triplets(a:Array[Int],b:Array[Int],c:Array[Int]): Unit ={

  var tripletcount:Long =0

  val distinctA:Array[Int]  = removeduplictes(a)
  val distinctB:Array[Int]  = removeduplictes(b)
  val distinctC:Array[Int]  = removeduplictes(c)

  //sorting the array
  distinctA.sorted
  distinctB.sorted
  distinctC.sorted

  for(i <- 0 to distinctA.length-1){
    println(s"array ..${distinctA(i)}")
  }

  for(q <- distinctB){

    var c1 = getvalidindex(distinctA,q) +1 // =1coz index starts from zero
    var c3 = getvalidindex(distinctC,q) +1

    tripletcount += c1*c3

  }



}


def removeduplictes(arr:Array[Int]):Array[Int]={

var set : HashSet[Int] = HashSet.empty[Int]

  for(i <- 0 to arr.length-1){
    set.add(arr(i))
  }

  val len= set.size

  val slit = set.toArray

    slit

}


def getvalidindex(a:Array[Int],key:Int):Int ={

  var  low:Int  =0
  var high = a.length-1
  var count = -1

while(low <= high){

  val mid = low +(high-low)/2
  if(a(mid) <= key){
    count = mid
    low = mid+1
  }
  else {
    high = mid-1
  }
}

count

}

//val a = Array(3,5,7,7,1,1)
//val b= Array(3,5,7,7,1,1)
//val c = Array(3,5,7,7,1,1)

//triplets(a,b,c)

//this take o(n2) time
def triplet1(a:Array[Int],b:Array[Int],c:Array[Int])={

  val distincta:Array[Int]= a.sorted.toSet.toArray
  val distinctb:Array[Int]= b.sorted.toSet.toArray
  val distinctc:Array[Int]= c.sorted.toSet.toArray

  var ai:Int =0
  var bi:Int =0
  var ci:Int =0

  var ans:Int=0

   while(bi < distinctb.length){

       while (ai < distincta.length && a(ai) <= b(bi)){
         ai +=1
       }
     while (ci < distinctc.length && c(ci) <= b(bi)){
       ci +=1
     }

     ans += ai*ci

     bi +=1
   }
  println(s"count ...$ans")

}

val a = Array(3,5,7)
val b= Array(3,6)
val c = Array(4,6,9)

triplet1(a,b,c)