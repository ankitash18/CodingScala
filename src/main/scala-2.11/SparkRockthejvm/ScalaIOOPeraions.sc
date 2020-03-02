import scala.io.Source



case class order(name:String,ordrid:Int,order1:Int)

def parse(lines:String) : order={

  val p = lines.split(",")
  val name = p(0)
  val ordrid = p(1).toInt
  val order1 = p(2).toInt

  order(name,ordrid,order1)
}

  val datafile = Source.fromFile("C:\\Users\\AShrivastava\\Desktop\\IdeaProjects\\SparkSBT\\src\\main\\resources\\data\\text1.csv")

  /*
    * dataFile is of type scala.io.BufferedSource = non-empty iterator
    * In BufferedSource each element is a character
    */


val records = datafile.getLines()

val tempadata   = records.map(parse).toArray

for( i <- records)
  println(i)

/*
    * problem statement for the above file (dataFile) we need to extract order subtotal(Fifth Column)
    * and need to compute revenue for a orderId(Second column). For e.g for orderId 2
    */

//val filter1 = records.spli
val sum = tempadata.filter(_.ordrid == 2).map(_.order1).sum


//or

datafile.close

//we can also use order_itemsFilterMap.sum or order_itemsFilterMap.reduce(_ + _)

//ordermap.sum

//val records1 = records.next()

/*
This code shows how you can read a text file into a list of strings — List[String] — using Scala’s Try, Success, and Failure classes:

 import scala.util.{Try, Success, Failure}

def readTextFileWithTry(filename: String): Try[List[String]] = {
    Try {
        val lines = using(io.Source.fromFile(filename)) { source =>
            (for (line <- source.getLines) yield line).toList
        }
        lines
    }
}

val passwdFile = readTextFileWithTry("/etc/passwd")
passwdFile match {
    case Success(lines) => lines.foreach(println)
    case Failure(s) => println(s"Failed, message is: $s")
}

*/
case class Address(street: String, city: String, state: String, zipCode: String)
case class Person(first: String, last: String, address: Option[Address])

def zipForPerson(op: Option[Person]): Option[String] =
  for {
    p <- op
    a <- p.address
  } yield a.zipCode

val people = List(
  Some(Person("Fred", "Bloggs", None)),
  Some(Person("Simon", "Jones",
    Some(Address("123 Main", "Fakesville", "AZ", "12345")))),
  None
)

people.map(zipForPerson)   // List(None, Some(12345), None)

people(0).flatMap(_.address).map(_.zipCode)  // None
people(1).flatMap(_.address).map(_.zipCode)  // Some(12345)
people(2).flatMap(_.address).map(_.zipCode)  // None





