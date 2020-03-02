import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.sql._
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import  org.apache.spark.sql.SparkSession

object DF_UDEMY {

  case class person(id:Int,name:String,age:Int,numfrns:Int)

  def mapper(line:String):person ={

    val fields=line.split(",")

    val p:person =person(fields(0).toInt,fields(1),fields(2).toInt,fields(3).toInt)
    return p
  }

  //our main fnction where action happens

  def main(args:Array[String]): Unit ={

    //SET THE LOg level to only print error
    Logger.getLogger("org").setLevel(Level.ERROR)

    //use sparksession interface in spark 2.0

    val spark = SparkSession.builder()
      .appName("Dataframe")
      .master("local[*]")
      .config("spark.sql.warehouse.dir","file:///C:/Users/AShrivastava/Desktop/study/CCA 159 videos") //necessary to workaround a windows bug in sprak 2.0
      .getOrCreate()

    val lines = spark.sparkContext.textFile("src/main/resources/data/friends.txt")

      println(lines.take(3))

    import spark.implicits._

    val people = lines.map(mapper)

    println(people.take(3))



    //infer the schema and register the dataset as a tbale

    import spark.implicits._

    val schemappl = people.toDS().cache()

    //there are lot of other ways to create dtaafraes.
    //for example - spark.read.json(jsn file path)
    //or sqlcontext.table("hive table name)

    println("here is our inferred schema")
    schemappl.printSchema()

    println("lets select the name column")

    schemappl.select("name").show()

    println("filter out nayone over 21")
    schemappl.filter(schemappl("age")< 55).show()

    println("group by age")
    schemappl.groupBy("age").count().show()

    println("male everyme 10 yrs older")
    schemappl.select(schemappl("name"),schemappl("age")+10).show()

    spark.stop()




    //sql can be run over dataframes that have been registered as a tbale

    //teen is dataframe
  //  val teen = spark.sql("select * from people ")


    // teen.show()

  //  val results = teen.collect()
  //  results.foreach(println)

   // spark.stop()



  }

}

