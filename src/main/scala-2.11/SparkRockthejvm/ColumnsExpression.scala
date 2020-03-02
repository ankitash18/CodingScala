package SparkRockthejvm

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, column, expr}

/**
  * Created by AShrivastava on 1/18/2020.
  */
object ColumnsExpression  extends App{

  val spark = SparkSession.builder()
                     .appName("columns and expression")
                       .master("local")
                       .getOrCreate()

  val carsDF = spark.read
                    .option("inferSchema", "true")
                    .json("src/main/resources/data/cars.json")

  //carsDF.show()

  // create Columns
  //columns are spwscial obwjcr that allow you to create new dataframe  out of some source data frames by rpeocessign the valyes inside

  val firstColumn = carsDF.col("Name")

  //firstcolumn is plain jvm oject that has no data insde

  // selecting (projecting)
  val carNamesDF = carsDF.select(firstColumn)

 carNamesDF.show()

  // various select methods
  import spark.implicits._
  carsDF.select(
    carsDF.col("Name"),
    col("Acceleration"),
    column("Weight_in_lbs"),
    'Year, // Scala Symbol, auto-converted to column
    $"Horsepower", // fancier interpolated string, returns a Column object
    expr("Origin") // EXPRESSION
  ).show(5)

  // select with plain column names
  carsDF.select("Name", "Year").show(5)

  // EXPRESSIONS these re colum ntype
  val simplestExpression = carsDF.col("Weight_in_lbs")
  val weightInKgExpression = carsDF.col("Weight_in_lbs") / 2.2

  val carsWithWeightsDF = carsDF.select(
    col("Name"),
    col("Weight_in_lbs"),
    weightInKgExpression.as("Weight_in_kg"),
    expr("Weight_in_lbs / 2.2").as("Weight_in_kg_2")
  )//.show()




  // selectExpr// selectExpr

  val carsWithSelectExprWeightsDF = carsDF.selectExpr(
    "Name",
    "Weight_in_lbs",
  "Weight_in_lbs / 2.2"
  )//.show()

  // DF processing

  // adding a column

  val carsWithKg3DF = carsDF.withColumn("Weight_in_kg_3",col("Weight_in_lbs")/2.2)//.show()

  // renaming a column
  val carsWithColumnRenamed = carsDF.withColumnRenamed("Weight_in_lbs","weight in punds")//.show()

  // careful with column names
  carsWithColumnRenamed.selectExpr("`weight in punds`")//.show()

  // remove a column

  carsWithColumnRenamed.drop("Cylinders")//.show()

  // filtering
  val europeanCarsDF =carsDF.filter(col("Origin") =!= "USA")//.show()
  val europeanCarsDF2 = carsDF.where(col("Origin") === "USA")//.show()
  // filtering with expression strings

  val americanCarsDF = carsDF.filter("Origin = 'USA'")

  // chain filters

  val americanPowerfulCarsDF = carsDF.filter("Origin = 'USA'").filter(col("Horsepower") > 150)//.show()

  val americanPowerfulCarsDF2 = carsDF.filter(col("Origin") === "USA" and col("Horsepower") > 150)

  val americanPowerfulCarsDF3 = carsDF.filter("Origin = 'USA' and Horsepower > 150")

  // unioning = adding more rows

  val moreCarsDF = spark.read
            .option("inferSchema", "true")
            .json("src/main/resources/data/more_cars.json")

  val allCarsDF = carsDF.union(moreCarsDF) // works if the DFs have the same schema

  //allCarsDF.show()

  // distinct values
  val allCountriesDF = carsDF.select("Origin").distinct()//.show()

  /**
    * Exercises
    *
    * 1. Read the movies DF and select 2 columns of your choice
    * 2. Create another column summing up the total profit of the movies = US_Gross + Worldwide_Gross + DVD sales
    * 3. Select all COMEDY movies with IMDB rating above 6
    *
    * Use as many versions as possible
    */

  val moviesDF = spark.read
                      .option("inferSchema", "true")
                      .json("src/main/resources/data/movies.json")


  val moviesReleaseDF = moviesDF.select("Title", "Release_Date")//show()

  val moviesReleaseDF2 = moviesDF.select(
    moviesDF.col("Title"),
    col("Release_Date"),
    $"Major_Genre",
    expr("IMDB_Rating")
  )
  val moviesReleaseDF3 = moviesDF.selectExpr(
    "Title", "Release_Date"
  )

  //2---------
  val moviesProfitDF = moviesDF.select(
    col("Title"),
    col("US_Gross"),
    col("Worldwide_Gross"),
    col("US_DVD_Sales"),
    (col("US_Gross") + col("Worldwide_Gross")).as("Total_Gross")
  )//.show()

  val moviesProfitDF2 = moviesDF.selectExpr(
    "Title",
    "US_Gross",
    "Worldwide_Gross",
    "US_Gross + Worldwide_Gross as Total_Gross"
  )//.show()

  val moviesProfitDF3 = moviesDF.select("Title", "US_Gross", "Worldwide_Gross")
    .withColumn("Total_Gross", col("US_Gross") + col("Worldwide_Gross"))

  //moviesProfitDF3.show()

  //3-------------------------------

  val atLeastMediocreComediesDF = moviesDF.select("Title", "IMDB_Rating","Major_Genre").where(col("Major_Genre") === "Comedy" and col("IMDB_Rating") > 6)

//  atLeastMediocreComediesDF.show()

  val comediesDF2 = moviesDF.select("Title", "IMDB_Rating")
    .where(col("Major_Genre") === "Comedy")
    .where(col("IMDB_Rating") > 6)

  comediesDF2.show()

  val comediesDF3 = moviesDF.select("Title", "IMDB_Rating")
    .where("Major_Genre = 'Comedy' and IMDB_Rating > 6")

  println(comediesDF3.count())
}
