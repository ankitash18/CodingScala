package DFbasics

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.SparkSession


/**
  * Created by AShrivastava on 3/31/2019.
  * ifworking with spark 2.x or higher ,supports  csv,json,parquet file formats
  *
  * if workign with spakr 1.x,
  *
  * json,ORC,parquet
  *
  * avro file format - doenwload the depenedcy from mvn rpeosiotyr ,add it in buold path or pom
  */
object DFfileformat {

  def main(args: Array[String]) = {


    val spark = SparkSession.builder().appName("DF file format")
                   .master("local")
                     .getOrCreate()

    val jsonDF= spark.read.json("src/main/resources/data/example_2.json")

    jsonDF.printSchema()
    jsonDF.show()

  }

}
