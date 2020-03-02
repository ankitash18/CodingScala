package DFbasics
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}


/**
  * Created by AShrivastava on 3/27/2019.
  In spark 1.x, Df is created using sql context and sql context is create using  Spark
  */
object DFWithSC {

  def main(args: Array[String])= {

    val conf = new SparkConf().setMaster("local").setAppName("Creating Data Frame with spark context ")

    val sc = new SparkContext(conf)

    val sqlconntext = new SQLContext(sc)

      val rdd = sc.parallelize(Array(1,2,3,4,5))

    val schema =StructType(
                    StructField("ID",IntegerType,false) :: Nil
    )

    val rowRDD =rdd.map(line => Row(line))

    val DF = sqlconntext.createDataFrame(rowRDD,schema)

    DF.printSchema()

    DF.show() //equivalent to collect method in RDD









  }

}
