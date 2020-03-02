package DFbasics
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.SparkSession


/**
  * Created by AShrivastava on 3/28/2019.
  */
object DFWithCSV {

  def main(args: Array[String]) = {


    val spark = SparkSession.builder()
      .appName("creating df with csv file")
      .master("local")
      .getOrCreate()


    val df = spark.read
      //  .option("header","true")
      // .option("inferSchema","true")
      .options(Map("header" -> "true","inferScehma" -> "true"))
      .csv("src/main/resources/data/tempfile.csv")

    // df.printSchema()

    println(df.first().mkString(""))

    // df.show()


  }



}
