package SparkRockthejvm

import org.apache.spark.sql.SparkSession

/**
  * Created by AShrivastava on 2/1/2020.
  */
object MapVsFlatMap extends App {

  val spark = SparkSession.builder()
    .appName("Introduction to RDDs")
    .master("local")
    .getOrCreate()


  // the SparkContext is the entry point for low-level APIs, including RDDs
  val sc = spark.sparkContext
  val data = Seq("this is simpel string",
                  "one more simpe string",
                    "thri line")


 val df = sc.parallelize(data)

  //map

  //rdd of array
  //df.map(x => (x,x.length)).collect()

  val df2 = df.map(x => x.split(" ")).collect()

 // df2.collect().foreach(println)

//rdd of string
  val ldf3 = df.flatMap(x => x.split(" "))

  ldf3.collect.foreach(println)



}
