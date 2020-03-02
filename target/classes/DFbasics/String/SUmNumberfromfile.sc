/*
The objective here is to read a text file of numbers, one number to a line, and print out the sum of these numbers.
 */

import scala.collection.mutable.LinkedHashMap
import scala.io._


// the scala way
def computeSumOfValues2(file: String): Int = {
  var sum = 0
  lines(file).foreach ({
            sum += toNumber(_)})
  sum
}

def lines(file:String):Iterator[String]={

  val source = Source.fromFile(file)

  source.getLines()


}

 def toNumber(s: String): Int = {
  try {
    Integer.parseInt(s)
  } catch {
    case ex: NumberFormatException => 0
  }
}

computeSumOfValues2("src//main//resources//data//number.txt")

//Compute Word Frequency from Text File
def computeWordFrequencyMap2(file: String): Map[String,Int] = {
  var wordcounts = Map.empty[String,Int]
  for (line <- lines(file);
       word <- line.split("[ ,;.!?]+")
       if (word.trim.length > 0)) {
    addWord((word), wordcounts)
  }
  wordcounts
}

// refactored out to make the second version easier to write
def addWord(word: String, map: Map[String,Int]): Unit = {
  val origCount = if (map.contains(word)) map(word) else 0
  map + (word -> (origCount + 1))
}

//Sort a Map[String,Int] by Value

def sortByValue(unsorted: Map[String,Int]): Map[String,Int] = {
  val sortedMap = new LinkedHashMap[String,Int]()
  val keys = unsorted.keys.toList

  // sort in descending order of value
  val sortedKeys = keys.sort((a,b) => {unsorted(a) > unsorted(b)})
  sortedKeys.foreach(key => sortedMap + (key -> (unsorted(key))))
  sortedMap
}
