import org.apache.log4j.Logger
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import  org.apache.spark.sql.SparkSession


object SparkSession1 {

  def main(args: Array[String]){


    //  println("hello")
    val conf = new SparkConf().setMaster("local").setAppName("Scala outputfile")
    val sc = new SparkContext(conf)

    // load the file inn RDD
    //val input = sc.textFile("C:\\Users\\AShrivastava\\Desktop\\study\\spark-2.0.1-bin-hadoop2.7\\spark-2.0.1-bin-hadoop2.7\\ex1.txt")

    val sparksession =SparkSession.builder().appName("creatuing  contetx with spark session")
      .master("local")
      .getOrCreate()



    //val input = sparksession.read.csv("data/tempfile.csv")

    val input = sparksession.sparkContext.textFile("data/tempfile.csv",2)



    //  println(input.count())

    //  println(input.first())

    //display first 3 lines in RDD
    println(input.take(3))

    input.collect().foreach(println)


    input.take(3).foreach(println)

  }



}
