import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql._
import org.apache.spark._
import org.apache.spark.sql.functions._

import scala.io.Source
import scala.math._
import scala.io.Codec


//using broadcast variable
object Movie_dataset {

  def loadmovienames() :Map[Int,String] ={

    //create a map of int,stirng and populate it from item.data

    var movienames:Map[Int,String] = Map()  //initializes it as empty map

    val lines = Source.fromFile("src/main/resources/data/item.data").getLines()

    for(line <- lines) {

      var fields = line.split("\t")

      if(fields.length > 1){
        movienames += (fields(0).toInt -> fields(1))
      }
    }
    return  movienames //scala map object

  }

  //case class so that we can get a column name for movie id
  final case class Movie(movieid:Int)


  //our main functuon where action happens

  def main(args: Array[String]): Unit = {
    //SET THE LOg level to only print error
    Logger.getLogger("org").setLevel(Level.ERROR)

    //use sparksession interface in spark 2.0

    val spark = SparkSession.builder()
      .appName("popluar movie using datset")
      .master("local[*]")
      .config("spark.sql.warehouse.dir","file:///C:/Users/AShrivastava/Desktop/study/CCA 159 videos") //necessary to workaround a windows bug in sprak 2.0
      .getOrCreate()

    val lines = spark.sparkContext.textFile("src/main/resources/data/movie.data").map(x => Movie(x.split("\t")(1).toInt))

    //lines is an RDD of movie objects(movie id)
  //convert to datset

    import spark.implicits._

    val movieds = lines.toDS()

    //some sql style magic to sort all the movie names by popularity in onel ine

    val topmovie = movieds.groupBy("movieid").count().orderBy(desc("count")).cache()

    topmovie.show()

    val top3 = topmovie.take(3)


//loafd u the movied - name map

    val names = loadmovienames()

    //print the reslts

 //   for(result <- top3){

     //reslt is just s row at this point,we needto cast it back
      //each row has movie id ,count
  //    println(names(result(0).asInstanceOf[Int])+ ":" +result(1))


   // }

    spark.stop()


  }



}
