val s = "hello world"

s.splitAt(2)

s.split(" ")

val fruits = Seq("apple", "banana", "orange")

fruits.map(_.toUpperCase)

fruits.flatMap(_.toUpperCase())

val plusone =Iterator.iterate(6)(n => n+1)

plusone.take(6).foreach(println)



val left = Vector(1,2,3,4)

val leftsub = for(i <- 1 to left.length)
  yield left.takeRight(i).sum

val right = Vector(5,6,7,8)

val rightsub = for(i <- 1 to left.length)
  yield right.takeRight(i)

val(x,y) = left.splitAt(2)

val upper = "hello, world".filter(_ != 'l').map(_.toUpper)



val upper1 = for (c <- "hello, world") yield c.toUpper


val result = for {
  c <- "hello, world"
  if c != 'l'
} yield c.toUpper


"HELLO".map(c => (c.toByte+32).toChar)


//using a .r mehtod on string is to creat a regex object

/*
Using the .r method on a String is the easiest way to create a Regex object. Another
approach is to import the Regex class, create a Regex instance, and then use the instance
in the same way:
 */
val numPattern = "[0-9]+".r

val address = "123 Main Street Suite 101"

val match1 = numPattern.findFirstIn(address)

val matches = numPattern.findAllIn(address)
matches.foreach(println)

val matches1 = numPattern.findAllIn(address).toArray

import scala.util.matching.Regex


val numPattern1 = new Regex("[0-9]+")


val address1= "123 Main Street Suite 101"

val match2 = numPattern.findFirstIn(address)


match1 match {
  case Some(s) => println(s"Found: $s")
  case None =>
}

/*

match1 match {
case Some(s) => println(s"Found: $s")
case None =>
}
 */

val address3= "123 Main Street".replaceAll("[0-9]", "x")
val result5 = "123".replaceFirst("[0-9]", "x")


/*

You want to extract one or more parts of a string that match the regular-expression
patterns you specify.
 */

val pattern = "([0-9]+) ([A-Za-z]+)".r

val pattern(count, fruit) = "100 Bananas"

val MoviesZipRE = "movies (\\d{5})".r

val MoviesNearCityStateRE = "movies near ([a-z]+), ([a-z]{2})".r

/*
As you just saw, in Scala, you can add new functionality to closed classes by writing
implicit conversions and bringing them into scope when you need them. A major benefit
of this approach is that you don’t have to extend existing classes to add the new functionality.
For instance, there’s no need to create a new class named MyString that extends
String, and then use MyString throughout your code instead of String; instead, you
define the behavior you want, and then add that behavior to all String objects in the
current scope when you add the import statement.
 */

implicit class StringImprovements(s: String) {
   def increment = s.map(_.toUpper)
  def hideAll = s.replaceAll(".", "*")
   }


val resul7 = "hal".increment

"ankita".hideAll

//implicit class StringToInt(s: String) {
 // def toInt(radix: Int) = Integer.parseInt(s, radix)
//}

def toInt1(s: String):Option[Int] = {
  try {
    Some(s.toInt)
  } catch {
    case e: NumberFormatException => None
  }
}
toInt1("100")

val aString ="ankia"

toInt1(aString) match {
  case Some(n) => println(n)
  case None => println("Boom! That wasn't a number.")
}


/*

You need to create random numbers, such as when testing an application, performing
a simulation, and many other situations.
 */

//val r = scala.util.Random

//r.nextInt()

/*
You need to create a range, list, or array of numbers, such as in a for loop, or for testing
purposes.
 */
val z = (1 to 10).toList

val e = (1 to 10).toArray

val pi = scala.math.Pi

f"$pi%1.5f"


/*

 */import java.util.{Currency, Locale}

val de = Currency.getInstance(new Locale("de", "DE"))

def listToString(list: List[String]): String = list match {
  case s :: rest => s + " " + listToString(rest)
  case Nil => ""
}

val fruits1 = "Apples" :: "Bananas" :: "Oranges" :: Nil
listToString(fruits1)


def sum(list: List[Int]): Int = list match {
  case Nil => 1
  case n :: rest => n + sum(rest)
}
def multiply(list: List[Int]): Int = list match {
  case Nil => 1
  case n :: rest => n * multiply(rest)
}




