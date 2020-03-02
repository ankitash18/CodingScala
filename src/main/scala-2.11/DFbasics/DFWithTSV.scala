package DFbasics

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{ DataFrame, Row, SQLContext,Column }
/**
  * Created by AShrivastava on 7/12/2019.
  */
object DFWithTSV {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder()
      .appName("creating df with tsv file")
      .master("local")
      .getOrCreate()

    import org.apache.spark.sql.types._

    var gtscehma = StructType(Array(
      StructField("FCC",         StringType, true),
      StructField("FCC_PACK",    StringType, true),
      StructField("EAN",  StringType, true),
      StructField("NATIONAL_CODE",   IntegerType, true),
      StructField("COUNT",  StringType, true)
    ))



    val df: DataFrame = spark.read.format("csv")
      //  .option("header","true")
      // .option("inferSchema","true")
      .options(Map("header" -> "true", "inferScehma" -> "true"))
        .option("delimiter","\t")
       // .option("re")
         .schema(gtscehma)
      .load("src/main/resources/data/SP_W502016_COMBI.txt")

    df.printSchema()


    val newdf=
      df.withColumn("count_new",trim(df("count"))).drop("count")


    //df.select(col("count"),translate(col("count"),".","").as("count_new")).show(10)

        //.drop("count_new")




    df.printSchema()

    df.show(20)

  }
}