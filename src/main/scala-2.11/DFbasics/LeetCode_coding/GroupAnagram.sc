/*
Maintain a map ans : {String -> List}
where each key \text{K}K is a sorted string,
and each value is the list of strings from the initial input that when sorted, are equal to \text{K}K.

Here, we first sort each word, use sorted word as key and then put original word in a map. The value of the map will be a list containing all the words which have same word after sorting.
Lastly, we will print all values from the hashmap where size of values will be greater than 1.


 */

import java.util

import scala.collection.mutable.{ArrayBuffer, HashMap, ListBuffer}

def groupanagram(strs:Array[String]):Unit={


  val map:HashMap[String,ListBuffer[String]] = HashMap.empty[String,ListBuffer[String]]
  // loop over all words

  for( i <- 0 to strs.length-1) {

    val word = strs(i)
    // println("word"+ word)
    val letters: Array[Char] = word.toCharArray

      val newword = new String(letters.sorted)


    // convert to   lchar array, sort and
    // then re-convert to string

   // val newword = word.sorted
    println("newword.." + newword)
    println("word.." + word)

    // calculate hashcode of string
    // after sorting
    if (map.contains(newword)) {
       val k = map(newword)
        k.append(word)

    }

    else {
      // This is the first time we are
      // adding a word for a specific
      // hashcode
      val words = new ListBuffer[String]()

        words.append(word)
         //words.toList
        map.put(newword,words)

    }
  }

  // print all the values where size is > 1
  // If you want to print non-anagrams,
  // just print the values having size = 1

  for( (s,v)<- map){
    //val values = map(s).toList
      println(v)
  }

}

val strs = Array("ate","eat","tea","cat","tac")

groupanagram(strs)


