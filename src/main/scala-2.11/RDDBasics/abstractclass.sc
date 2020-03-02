
import java.time.LocalDate

//import javax.mail.{Authenticator, PasswordAuthentication}
//import javax.mail.internet.MimeMessage

abstract class Car(
                    val make: String,
                    val model: String,
                    val year: Int
                  ) {
  def isVintage: Boolean
}

val mustang = new Car("Ford", "Mustang", 1965) {
  def isVintage = LocalDate.now.getYear - year > 20
}

class Demo {
  val a: Int = {
    println("evaluating a")
    10
  }
  def b: Int = {
    println("evaluating b")
    20
  }
  lazy val c: Int = {
    println("evaluating c")
    30
  }
}

val demo = new Demo
demo.a
demo.b
demo.b
demo.c
demo.c


import java.time.LocalDate

case class Car1(make: String, model: String, year: Int) {
  lazy val isVintage: Boolean =
    LocalDate.now.getYear - year > 20
}

val mustang1 = Car1("Ford", "Mustang", 1965)

mustang1.make
mustang1.model
mustang1.year
mustang1.isVintage

mustang1 == Car1("Ford", "Mustang", 1965)
mustang1 == Car1("Ford", "Mustang", 1964)


val s1: String = "hello"

s1.charAt(1)

val s2: String = null

// NullPointerException...
//s2.charAt(1)

s1.isInstanceOf[String]
s2.isInstanceOf[String]



val emptyList = List.empty

1 :: emptyList
"hello" :: emptyList

def fail(msg: String): Nothing =
  throw new IllegalStateException(msg)



val flag = true  // could be false...

if (flag) 1.0 else ()  // Double + Unit = AnyVal

if (flag) 1.0  // implicit Unit, Double + Unit = AnyVal

if (flag) "hi" // implicit Unit, String + Unit = Any

if (flag) "Hello" else null // String + Null = String

if (flag) 2.0 else null // Double + Null = Any



if (flag) 2.0 else fail("not 2.0") // Double + Nothing = Double

if (flag) "yo" else fail("no yo") // String + Nothing = String

trait Fruit extends Product with Serializable

case class Apple(name: String) extends Fruit
case class Orange(name: String) extends Fruit

if (true) Apple("Fiji") else Orange("Jaffa")
List(Apple("fiji"), Orange("Jaffa"))



def addDoubles(a: Double, b: Double): Double = a + b

val a: Int = 7
val b: Int = 2

addDoubles(a, b)  // no need to convert - types are widened automatically

def addInts(a: Int, b: Int): Int = a + b

// addInts(1.0, 2.0)  // but only one way, have to explicitly narrow types
addInts(1.0.toInt, 2.0.toInt)

// Rich wrappers:

val d1 = -1.5
val d2 = 1.5

d1.abs
d1 min d2
d1 max d2

d1.floor
d2.ceil
d2.round

val str = "hello"
str.reverse
str.toSeq
str.slice(2, 4)


// @specialized to avoid unwanted boxing (but don't overuse)
def sumOf[@specialized(Int, Double, Long) T: Numeric](items: T*): T = {
  val numeric = implicitly[Numeric[T]]
  items.foldLeft(numeric.zero)(numeric.plus)
}

sumOf(1,2,3)

// Don't do this, just tuple them instead...
def pair[@specialized T, @specialized U](t: T, u: U): (T, U) = (t, u)


implicit class TimesDo(val i: Int) extends AnyVal {
  def times(fn: => Unit): Unit = {
    for (_ <- 1 to i) fn
  }
}

5 times {
  println("hello")
}

