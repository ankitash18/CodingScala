package SparkRockthejvm

import SparkRockthejvm.DataSources.carsDF
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._



/**
  * Created by AShrivastava on 2/16/2020.
  */
object SparkUDF extends App {


  val spark = SparkSession.builder().appName("udf").master("local").getOrCreate()

val  userdata = spark.createDataFrame(Seq(
  (1, "Chandler", "Pasadena", "US"),
  (2, "Monica", "New york", "USa"),
  (3, "Phoebe", "Suny", "USA"),
  (4, "Rachael", "St louis", "United states of America"),
  (5, "Joey", "LA", "Ussaa"),
  (6, "Ross", "Detroit", "United states")
)).toDF("id", "name", "city", "country")


  //val allUSA = Seq("US", "USa", "USA", "United states", "United states of America")

  def cleanCountry = (country: String) => {
    val allUSA = Seq("US", "USa", "USA", "United states", "United states of America")
      if (allUSA.contains(country)) {
      "USA"
      }
      else {
      "unknown"
      }
      }

  val normaliseCountry = spark.udf.register("normalisedcontry",cleanCountry)

  userdata.withColumn("normalisedcontry",normaliseCountry(col("country"))).show()

  userdata.write
    //.format("parquet")
    .mode("Overwrite")
    .save("src/main/resources/data/userate.parquet")



}
