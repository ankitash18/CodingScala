//val dataFile="src/main/resources/data/movietweets.csv"

//Source created from file
import scala.io.Source

val fileData  = Source.fromFile("C:\\Users\\AShrivastava\\Desktop\\study\\CCA 159 videos\\kickstart-scala\\data-files\\movietweets.csv").getLines()

//Split each line into words and add the words to a Buffer
var wordList = scala.collection.mutable.Buffer[String]()

//Split first by comma and then by space
for ( line <- fileData) {
  var firstSplit = line.split(",")
  for ( words1 <- firstSplit) {
    var words2 = words1.split(" ")
    for ( words3 <- words2) {
      wordList += words3
    }
  }
}

println(wordList.size)

//println(wordList.size)

//Now create a map that holds the words and their counts
var wordCounts = scala.collection.mutable.Map[String, Int]()

for ( word <- wordList.toArray ) {
  if ( ! wordCounts.contains(word) ) {
    wordCounts += ( word -> 0 )
  }

  wordCounts(word) = wordCounts(word) + 1
}

println("total positive : " + wordCounts("positive"))
println(wordCounts)




val length =Array(10,5,2,1)