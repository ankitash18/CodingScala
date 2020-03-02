package Socitie_general

import java.io.{FileNotFoundException,IOException}

import scala.io.Source

/*
The fromFile method returns a BufferedSource, and its getLines method treats “any
of \r\n, \r, or \n as a line separator (longest match),” so each element in the sequence
is a line from the file
 */

/**
  * Created by AShrivastava on 2/17/2020.
  */
object ScalaVersion extends App{

  //reading file

  //case class aadhar(sa:String,aua:Int)

  val filename = "C:\\Users\\AShrivastava\\Desktop\\IdeaProjects\\SparkSBT\\src\\main\\resources\\data\\auth.csv"


  //val  lines =  scala.io.Source.fromFile(filename).getLines().drop(1).toArray.take(10).foreach(println)
try {
  //The getLines method of the Source class returns a scala.collection.Iterator
  val bufferedSource = Source.fromFile(filename)
  for (line <- bufferedSource.getLines.take(10)) {
    println(line)
  }
  bufferedSource.close
} catch{
    case e:FileNotFoundException => println("file not found")
    case e:IOException => println("io excpetion")

  }

  //accessing csv file

  val buffeeresrc =  scala.io.Source.fromFile(filename)
  for( lines <- buffeeresrc.getLines.take(10)){
    val cols = lines.split(",").map(_.trim)
    println(s"${cols(2)},${cols(3)},${cols(128)}")
  }
  buffeeresrc.close()
  //coun lines

  val buffeeresrc1 =  scala.io.Source.fromFile(filename)
  var count = 0
   buffeeresrc1.getLines.foreach{ lines =>
   val line = lines.split(",").map(_.trim)
      count += 1
  }
  println(count)
  buffeeresrc1.close()

//writitng a file

  import java.io._
  val pw = new PrintWriter(new File("C:\\Users\\AShrivastava\\Desktop\\IdeaProjects\\SparkSBT\\src\\main\\resources\\data\\hello.txt" ))
  pw.write("Hello, world")
  pw.close
  // FileWriter
  /*
  val file = new File(canonicalFilename)
  val bw = new BufferedWriter(new FileWriter(file))
  bw.write(text)
  bw.close()
*/


 // val fileContents = Source.fromFile(filename).getLines.mkString(",")

 // val order_itemsFilter = lines.filter(x => x.split(",")(128) == "Delhi").filter(x => x.split(",")(2).toInt > 650000)//.take(10).forech(println)

  //fileContents.foreach(println)


  //val filter_data = lines.filter(x => x.split(",")(2) >= 650000).foreach(println)

 // val final_data = filter_data.map(x => x.split(",")(3).toInt)

   //println(final_data)




}
