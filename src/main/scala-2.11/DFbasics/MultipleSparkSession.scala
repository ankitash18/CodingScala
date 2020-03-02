package DFbasics
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.SparkSession


/**
  * Created by AShrivastava on 3/31/2019.
  */
object MultipleSparkSession {


  def main(args: Array[String]) = {


     val spark1 = SparkSession.builder().master("local")
      .appName("multiple sparksession in single job")
      .getOrCreate()

    val spark2 = SparkSession.builder().master("local")
      .appName("multiple sparksession in single job")
      .getOrCreate()

    val rdd1 = spark1.sparkContext.parallelize((Array(1,2,3,4,5)))

    val rdd2 = spark2.sparkContext.parallelize((Array(6,7,8,9,10)))

    rdd1.collect().foreach(println)
    rdd2.collect().foreach(println)







  }

}
