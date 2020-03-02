val add3: (Int, Int, Int) => Int = (a, b, c) => a + b + c

val add3curried = add3.curried

val add3c: Int => Int => Int => Int = a => b => c => a + b + c

add3(1,2,3)
add3curried(1)(2)(3)
add3c(1)(2)(3)

add3c.apply(1).apply(2).apply(3)

def add3method(a: Int)(b: Int)(c: Int) = a + b + c
add3method(1)(2)(3)

add3method { 1 } { 2 } { 3 }

val sq: Int => Int = x => x * x  // Function1[Int, Int]
val add: (Int, Int) => Int = (a, b) => a + b  // Function2[Int, Int, Int]
val mult3: (Int, Int, Int) => Int = _ * _ * _ // Function3[Int, Int, Int, Int]


import scala.util.Random
val makeARandom: () => Double = () => Random.nextDouble()

makeARandom()
makeARandom()

import scala.annotation.tailrec

@tailrec
def fruitLoop(pred: () => Boolean)(body: () => Unit): Unit = {
  if (pred()) {
    body()
    fruitLoop(pred)(body)
  }
}

var x = 0

fruitLoop(() => x < 5) { () =>
  println(x * x)
  x += 1
}


@tailrec
def fruityLoop(pred: => Boolean)(body: => Unit): Unit = {
  if (pred) {
    body
    fruityLoop(pred)(body)
  }
}

var y = 0
fruityLoop(y < 5) {
  println(y * y)
  y += 1
}

val xs = List[1,2,3,4,5,6]

xs.exists(>_5)
