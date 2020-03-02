import scala.collection.mutable.HashMap
//Given an array of n words. Some words are repeated twice,
// we need count such words.
/*
Traverse the given array, store counts of words in a hash table
Traverse hash table and count all words with count 2.
 */

//// Returns count of words with frequency
// exactly 2

def countWords(str:Array[String],n:Int):Int ={


  // map to store count of each word

  val m : HashMap[String,Int] = HashMap.empty[String,Int]


  for(i <- 0 to n-1){
    m.put(str(i),m.getOrElse(str(i),0)+1)

  }

 var result =0

  for((key,value) <- m){

    if(value == 2){
      result +=1
    }
  }
  result
}

val a = Array("hate", "love", "peace", "love", "peace", "hate", "love", "peace", "love", "peace","Om","Om")

val n = a.length

countWords(a,n)

