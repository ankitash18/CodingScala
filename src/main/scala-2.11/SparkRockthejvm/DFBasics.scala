package SparkRockthejvm

import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.types._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.expressions.Window._
import org.apache.spark.sql.functions._

/**
  * Created by AShrivastava on 1/18/2020.
  */
object DFBasics extends App{

  //crreating a sparksession

  val spark = SparkSession.builder().appName("dataframe basics")
                                .master("local")
                                .getOrCreate()

  //reading a df
  val firstDF = spark.read.format("json")
                    .option("inferSchema","true")
                      .load("src/main/resources/data/cars.json")

 // firstDF.show()

  //the types knows at compile time in dataframes

//  firstDF.printSchema()


  // get rows array of things
  //firstDF.take(10).foreach(println)

  //spark tpes
  // spark types
  val longType = LongType

  // schema
  val carsSchema = StructType(Array(
    StructField("Name", StringType),
    StructField("Miles_per_Gallon", DoubleType),
    StructField("Cylinders", LongType),
    StructField("Displacement", DoubleType),
    StructField("Horsepower", LongType),
    StructField("Weight_in_lbs", LongType),
    StructField("Acceleration", DoubleType),
    StructField("Year", StringType),
    StructField("Origin", StringType)
  ))

  // obtain a schema
  val carsDFSchema = firstDF.schema

  //carsDFSchema.foreach(println)

  // read a DF with your schema
  val carsDFWithSchema = spark.read
    .format("json")
    .schema(carsDFSchema)
    .load("src/main/resources/data/cars.json")



  //carsDFWithSchema.printSchema()

  // create rows by hand
  val myRow = Row("chevrolet chevelle malibu",18,8,307,130,3504,12.0,"1970-01-01","USA")


  // create DF from tuples
  val cars = Seq(
    ("chevrolet chevelle malibu",18,8,307,130,3504,12.0,"1970-01-01","USA"),
    ("buick skylark 320",15,8,350,165,3693,11.5,"1970-01-01","USA"),
    ("plymouth satellite",18,8,318,150,3436,11.0,"1970-01-01","USA"),
    ("amc rebel sst",16,8,304,150,3433,12.0,"1970-01-01","USA"),
    ("ford torino",17,8,302,140,3449,10.5,"1970-01-01","USA"),
    ("ford galaxie 500",15,8,429,198,4341,10.0,"1970-01-01","USA"),
    ("chevrolet impala",14,8,454,220,4354,9.0,"1970-01-01","USA"),
    ("plymouth fury iii",14,8,440,215,4312,8.5,"1970-01-01","USA"),
    ("pontiac catalina",14,8,455,225,4425,10.0,"1970-01-01","USA"),
    ("amc ambassador dpl",15,8,390,190,3850,8.5,"1970-01-01","USA")
  )

 val manualCarsDF = spark.createDataFrame(cars) // schema auto-inferred




  // note: DFs have schemas, rows do not(rows are unstrutured data)

  //manualCarsDF.take(10).foreach(println)

  // create DFs with implicits
  // small s in spark..means it is spark obejct crated ..spark context
  import spark.implicits._
  val manualCarsDFWithImplicits = cars.toDF("Name", "MPG", "Cylinders", "Displacement", "HP", "Weight", "Acceleration", "Year", "CountryOrigin")

 // manualCarsDF.printSchema()
// manualCarsDFWithImplicits.printSchema()

  //using window function

  val prc = Seq(
    (25,6001,2),
    (11,5001,8),
    (23,123,5)
  )

  val df5 = prc.toDF("userid","prodcut","count")

  println(s"...showing df5")

  df5.printSchema()
  df5.show()

  val w = Window.orderBy("count")
  val result = df5.withColumn("index",row_number().over(w))

  result.show()





  /**
    * Exercise:
    * 1) Create a manual DF describing smartphones
    *   - make
    *   - model
    *   - screen dimension
    *   - camera megapixels
    *
    * 2) Read another file from the data/ folder, e.g. movies.json
    *   - print its schema
    *   - count the number of rows, call count()
    */

  // 1
  val smartphones = Seq(
    ("Samsung", "Galaxy S10", "Android", 12),
    ("Apple", "iPhone X", "iOS", 13),
    ("Nokia", "3310", "THE BEST", 0)
  )
  val smartphonesDF = smartphones.toDF("Make", "Model", "Platform", "CameraMegapixels")

  smartphonesDF.show()

  smartphonesDF.printSchema()

 println(smartphonesDF.rdd.partitions.size)

  // 2
  val moviesDF = spark.read
                    .format("json")
                  .option("inferSchema", "true")
                .load("src/main/resources/data/movies.json")

  moviesDF.printSchema()
  moviesDF.count()
  println(s"The Movies DF has ${moviesDF.count()} rows")



}
