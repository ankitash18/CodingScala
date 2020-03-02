package Socitie_general

import java.lang.Integer

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{col, column, expr}
import org.apache.spark.sql.types.IntegerType

/**
  * Created by AShrivastava on 2/17/2020.
  */
object Spark_Program {

  def main(args: Array[String]): Unit = {

  val spark = SparkSession.builder()
              .appName("Get Service Agency")
              .master("local")
              .getOrCreate()


  val filepath = "src/main/resources/data/auth.csv"
  val authdf = get_dataframe(filepath,spark)

    println("getting the service agency")

    val SuDf1 = authdf.select(col("sa"))
    SuDf1.persist()
    val SuDf =            SuDf1.where(col("aua") >= "650000" and col("res_state_name") =!= "Delhi" )
                   .withColumn("newcol", col("sa").cast(IntegerType)).filter("newcol is not null")
                   .drop(col("newcol"))
println(SuDf.count())
    SuDf.show()





}

def get_dataframe(filepath:String,spark:SparkSession):DataFrame=  spark.read
              .format("csv")
              .option("header","true")
              .option("delimiter", ",")
              .load(s"$filepath")



}
