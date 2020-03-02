package SparkRockthejvm

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession

/**
  * Created by AShrivastava on 2/12/2020.
  */
object Basic_DF extends App{

  val spark = SparkSession.builder()
                    .appName("basic")
                       .master("local")
                        .getOrCreate()

  val sc = spark.sparkContext

  val inputIntegers = List(1, 2, 3, 4, 5) //an immutable list

  val integerRdd = sc.parallelize(inputIntegers)

  integerRdd.collect.foreach(println)
 // integerRdd.persist(StorageLevel.MEMORY_ONLY)
  println(integerRdd.reduce((x, y) => x * y))

  println(integerRdd.count)

}
