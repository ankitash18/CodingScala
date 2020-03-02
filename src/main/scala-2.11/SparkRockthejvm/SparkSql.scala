package SparkRockthejvm

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._


object SparkSql {


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
      .appName("sparkSql")
      .master("local[*]")
      .config("spark.sql.warehouse.dir","file:///C:/Users/AShrivastava/Desktop/study/CCA 159 videos") //necessary to workaround a windows bug in sprak 2.0
      .getOrCreate()

    val lines = spark.sparkContext.textFile("src/main/resources/data/friends.txt")

  //  println(lines.take(3))


    val people = lines.map(mapper)





    //infer the schema and register the dataset as a tbale

    import spark.implicits._

    val schemappl = people.toDS()


    schemappl.printSchema()

    schemappl.createOrReplaceTempView("people")

    //sql can be run over dataframes that have been registered as a tbale

    //teen is dataframe
   val teen = spark.sql("select * from people ")


   // teen.show()

    val results = teen.collect()
   // results.foreach(println)

    import spark.implicits._

    val empDF = spark.createDataFrame(Seq(
      (7369, "SMITH", "CLERK", 7902, "17-Dec-80", 800, 20, 10),
      (7499, "ALLEN", "SALESMAN", 7698, "20-Feb-81", 1600, 300, 30),
      (7521, "WARD", "SALESMAN", 7698, "22-Feb-81", 1250, 500, 30),
      (7566, "JONES", "MANAGER", 7839, "2-Apr-81", 2975, 0, 20),
      (7654, "MARTIN", "SALESMAN", 7698, "28-Sep-81", 1250, 1400, 30),
      (7698, "BLAKE", "MANAGER", 7839, "1-May-81", 2850, 0, 30),
      (7782, "CLARK", "MANAGER", 7839, "9-Jun-81", 2450, 0, 10),
      (7788, "SCOTT", "ANALYST", 7566, "19-Apr-87", 3000, 0, 20),
      (7839, "KING", "PRESIDENT", 0, "17-Nov-81", 5000, 0, 10),
      (7844, "TURNER", "SALESMAN", 7698, "8-Sep-81", 1500, 0, 30),
      (7876, "ADAMS", "CLERK", 7788, "23-May-87", 1100, 0, 20)
    )).toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno")

/*
First of all we will need to define the window we will be working on i.e. we will partition by department (deptno) and order by salary (sal). Below is the code to do it via Spark Dataframe API.
 */


    import org.apache.spark.sql.expressions.Window._

    // Windows are partitions of deptName

    val partitionWindow = Window.partitionBy($"deptno").orderBy($"sal".desc)

  /*
  Rank salary within each department
  /SQL
SELECT empno,deptno,sal,avg(sal) OVER (PARTITION BY deptno ORDER BY sal desc) as running_total FROM emp;

   */

    //DF API


    //DF API
    val sumTest = avg($"sal").over(partitionWindow)
    empDF.select($"*", sumTest as "running_total").show


    spark.stop()



  }

}
