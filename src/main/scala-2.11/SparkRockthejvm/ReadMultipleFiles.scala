package SparkRockthejvm


import  org.apache.spark.sql.SparkSession

/*
Let’s see a similar example with wholeTextFiles() method. note that this returns an RDD[Tuple2].
where first value (_1) in a tuple is a file name and second value (_2) is content of the file.
 */



/**
  * Created by AShrivastava on 2/13/2020.
  */
object ReadMultipleFiles extends App{

  val spark = SparkSession.builder().master("local").appName("multiple files").getOrCreate()

  val sc  = spark.sparkContext

val df = sc.textFile("src/main/resources/data/multi/*")

  df.foreach(x => {

      println(x)
  })

  df.saveAsTextFile("src/main/resources/data/multi/combine.txt")

}
