import scala.collection.mutable

/*
CHECK IF tw ostrings are anagram to each tother
An anagram of a string is another string that contains same characters, only the order of characters can be different.
Method 1 (Use Sorting)

Sort both strings
Compare the sorted strings
 */
/* function to check whether two strings are
    anagram of each other */
def anagram(str1:String,str2:String):Boolean={

  // Get lenghts of both strings
  val n1 = str1.length
  val n2 = str2.length

  // If length of both strings is not same,
  // then they cannot be anagram

  if(n1 != n2)
    return  false

  //sort the string
 // val s1= str1.sorted
  //val s2 =str2.sorted

  // Compare sorted strings

  if(str1.sorted == str2.sorted)
    return true
  else
  return false

  //or

 /* for( i <- 0 until n1){
    if(s1(i) != s2(i))
      return  false

  }
  */
 // return  true

}

//anagram("listen","silent")

//using hashmap
/*
: Hashmaps can also be used to
find if any two given strings are anagrams or not,
 by mapping the characters of each string to individual hashmaps and comparing them together.
 By default, HashMap.equals() method compares two hashmaps by key-value pairs
 */
import scala.collection.mutable.HashMap

def anagramhashmap(s1:String,s2:String):Boolean={


  val hmap1: HashMap[Char,Int]= HashMap.empty[Char,Int]
  val hmap2: HashMap[Char,Int]= HashMap.empty[Char,Int]

  if(s1.length != s2.length)
    return  false

  for( i <- 0 to s1.length-1){
    hmap1.put(s1(i),hmap1.getOrElse(s1(i),0)+1)
  }

  for( i <- 0 to s2.length-1){
    hmap2.put(s2(i),hmap2.getOrElse(s2(i),0)+1)
  }


if(hmap1.equals(hmap2))
  return true
  else
  true


}

anagramhashmap("eat","ate")

//def isAnagram(s: String, t: String): Boolean = s.groupBy(identity).mapValues(_.length) == t.groupBy(identity).mapValues(_.length)