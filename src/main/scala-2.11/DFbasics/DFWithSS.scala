package DFbasics
package DFbasics
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.SparkSession


/**
  * Created by AShrivastava on 3/27/2019.
  *  In spark 1.x, Df is created using sparksession
*/
object DFWithSS {


  def main(args: Array[String]) = {


    val spark = SparkSession.builder()
                   .appName("Creating DF using SparkSession")
                     .master("local")
                       .getOrCreate()


    val rdd = spark.sparkContext.parallelize((Array("1","2","3","4","6","7","8")))

    val schema = StructType(
                      StructField("ID",StringType,false):: Nil

    )

    val rowRDD = rdd.map(line => Row(line))

    val df = spark.createDataFrame(rowRDD,schema)

    df.printSchema()

    df.show()

      df.show(3)




  }

}
