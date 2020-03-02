package SparkRockthejvm

import org.apache.spark.sql.SparkSession
import  org.apache.spark.sql.types._

/**
  * Created by AShrivastava on 1/18/2020.
  */
object DataSources extends App{


  val spark= SparkSession.builder().appName("data spurces").master("local").getOrCreate()

  val carsSchema = StructType(Array(
    StructField("Name", StringType),
    StructField("Miles_per_Gallon", DoubleType),
    StructField("Cylinders", LongType),
    StructField("Displacement", DoubleType),
    StructField("Horsepower", LongType),
    StructField("Weight_in_lbs", LongType),
    StructField("Acceleration", DoubleType),
    StructField("Year", DateType),
    StructField("Origin", StringType)
  ))
  /*
     Reading a DF:
     - format
     - schema or inferSchema = true
     - path
     - zero or more options
     //permissive - default - spark will ignore the recoed with invalid value
    */
  val carsDF = spark.read
    .format("json")
    .schema(carsSchema) // enforce a schema
    .option("mode", "failFast") // dropMalformed, permissive (default) it decide wht sparks should do if it encounters a malformed record
    .option("path", "src/main/resources/data/cars.json")
    .load()

  carsDF.show()

  // alternative reading with options map
  val carsDFWithOptionMap = spark.read
    .format("json")
    .options(Map(
      "mode" -> "failFast",
      "path" -> "src/main/resources/data/cars.json",
      "inferSchema" -> "true"
    ))
    .load()


  /*
 Writing DFs this return dataframe writer
 - format
 - save mode = overwrite, append, ignore, errorIfExists
 - path
 - zero or more options
*/

  carsDF.write
    .format("json")
    .mode("Overwrite")
    .save("src/main/resources/data/cars_dupe.json")

  // JSON flags
  spark.read
      //.format("json")
    .schema(carsSchema)
    .option("dateFormat", "YYYY-MM-dd") // couple with schema; if Spark fails parsing, it will put null
    .option("allowSingleQuotes", "true")
    .option("compression", "uncompressed") // bzip2, gzip, lz4, snappy, deflate
    .json("src/main/resources/data/cars.json")

  // CSV flags
  val stocksSchema = StructType(Array(
    StructField("symbol1", StringType),
    StructField("date1", DateType),
    StructField("price1", DoubleType)
  ))

  spark.read
    .schema(stocksSchema)
    .option("dateFormat", "MMM dd YYYY")
    .option("header", "true")
    .option("delimiter", ",")
    .option("nullValue", "")
    .csv("src/main/resources/data/stocks.csv")
    //.show()

  // Parquet
  carsDF.write
    //.format("parquet")
    .mode("Overwrite")
    .save("src/main/resources/data/cars.parquet")

  // Text files
  //spark.read.text("src/main/resources/data/sampleTextFile.txt").show()

  /*


  // Reading from a remote DB
  val driver = "org.postgresql.Driver"
  val url = "jdbc:postgresql://localhost:5432/rtjvm"
  val user = "docker"
  val password = "docker"

  val employeesDF = spark.read
    .format("jdbc")
    .option("driver", driver)
    .option("url", url)
    .option("user", user)
    .option("password", password)
    .option("dbtable", "public.employees")
    .load()
   */

  /**
    * Exercise: read the movies DF, then write it as
    * - tab-separated values file
    * - snappy Parquet
    * - table "public.movies" in the Postgres DB
    */

  val moviesDF = spark.read.json("src/main/resources/data/movies.json")
 //tsv
  moviesDF.write
            .format("csv")
             .option("header","true")
              .option("delimiter","\t")
                .save("src/main/resources/data/movies.csv")

  moviesDF.write
            .format("parquet")
           .save("src/main/resources/data/movies1.parquet")

  /*

   // save to DF
  moviesDF.write
    .format("jdbc")
    .option("driver", driver)
    .option("url", url)
    .option("user", user)
    .option("password", password)
    .option("dbtable", "public.movies")
    .save()
   */

}
