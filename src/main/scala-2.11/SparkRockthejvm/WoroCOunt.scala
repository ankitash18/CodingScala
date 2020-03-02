package SparkRockthejvm

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, Row, SaveMode, SparkSession}

/**
  * Created by AShrivastava on 1/31/2020.
  */
object WoroCOunt extends App{

  val spark= SparkSession.builder().appName("word Count").master("local")
      .config("spark.sql.warehouse.dir", "src/main/resources/warehouse").getOrCreate()

 val sc = spark.sparkContext

  val df = spark.read.text("src/main/resources/data/README.md")

 df.show(10)

  val df1= df.select(split(df("value")," ").as("words"))

  df1.show(10)
  //Next use explode transformation to convert the words array into a dataframe with word column. This is equivalent of using flatMap() method on RDD


  val wordddf =df1.select(explode(df1("words")).as("word"))

 wordddf.show(10)

  //Now you have data frame with each line containing single word in the file. So group the data frame based on word and count the occurrence of each word

  val wordcount = wordddf.groupBy("word").count()

  wordddf.createOrReplaceTempView("test")


//
  println("showing,,,df4")
  val   df4 =spark.sql(s"""select count(1) as cnt ,word from test group by word order by  cnt desc""".stripMargin)
  df4.show(10)

 //uasing rdd








  //wordcount is relatinal groued dataset

  wordcount.show(10)

  //his is the code you need if you want to figure out 20 top most words in the file

  wordcount.orderBy(desc("count"))//.show(10)

 //using rdd

 val inputfile = sc.textFile("src/main/resources/data/README.md")

 val counts = inputfile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_+_)

 //showing up rdd

 counts.collect.foreach(println)

 //without using spark

 val lines = List("Hello world", "This is a hello world example for word count")

 val words = lines.flatMap(_.split(" "))

 words.groupBy((word:String) => word).mapValues(_.length)


 /*

 val list = List(“Anish is working on BigData Technologies”,”Hello Anish”,”BigData”)
val words = list.flatMap(line => line.split(” “))
val keyData = words.map(word => (word,1))
val groupedData = keyData.groupBy(_._1)
val result = groupedData.mapValues(list=>{
list.map(_._2).sum
})
result.foreach(println)

str.split("").map(l => (l, 1)).reduceByKey(_+_)
  */

}
