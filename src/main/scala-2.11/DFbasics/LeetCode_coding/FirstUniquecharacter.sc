/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 */


import scala.collection.mutable.HashMap
//using hashmap
def uniquechar(s:String):Int={

  val hash:HashMap[Char,Int] = HashMap.empty[Char,Int]

  for(i <- 0 to s.length-1){

    hash.put(s(i),hash.getOrElse(s(i),0)+1)
  }

  for(i <- 0 to s.length-1){
    if(hash(s(i)) ==1){
        return i
    }
  }
  return  -1
}
val a ="leetcode"
uniquechar(a)
