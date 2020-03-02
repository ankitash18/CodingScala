package RDDBasics
import org.apache.log4j.Logger
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import  org.apache.spark.sql.SparkSession

/**
  * Created by AShrivastava on 3/20/2019.
  */
object RDDwithCSV {

  def main(args: Array[String]): Unit = {

    val  sc =SparkSession.builder().appName("RDD with CSV")
                 .master("local")
                   .getOrCreate()


    val csvRDD=sc.sparkContext.textFile("src/main/resources/data/tempfile.csv",2)

   // csvRDD.foreach(println)

    val header = csvRDD.first()

    val csvRDDwithouthdr = csvRDD.filter(_ != header)



    csvRDDwithouthdr.foreach(println)

    val ID =csvRDDwithouthdr.map(line => {
           val colarray =line.split(",")
            (colarray(0),colarray(2))
    }).foreach(println)  //tupple


    val ID1 =csvRDDwithouthdr.map(line => {
      val colarray =line.split(",")
      List(colarray(0),colarray(2))
    }).foreach(println)  //list

    val ID2 =csvRDDwithouthdr.map(line => {
      val colarray =line.split(",")
      Array(colarray(0),colarray(2)).mkString(";")
    }).foreach(println)  //list

    csvRDDwithouthdr.saveAsTextFile("target/output_files/tempfile")








  }

}
