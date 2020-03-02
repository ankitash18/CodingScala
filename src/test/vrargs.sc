val xs = List(1,2,3)
val ys = List(1,2,3,4,5)


def sayHello(names: String*): Unit = {
  for (name <- names) println(s"Hello, $name")
}
 //* means variable number i n parametrer
sayHello()
sayHello("Fred")
sayHello("Fred", "Julie", "Kim")


def greet(greeting: String, names: String*): Seq[String] = {
  for (name <- names) yield s"$greeting $name"
}

greet("Hi", "Fred", "Julie", "Kim")

greet("yo")


// greet a seq of names:

val names = List("Fred", "Julie", "Kim")

// greet("Hi", names)  // does not compile

greet("Hi", names: _*)  // expansion operator
