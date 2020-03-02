def multiplyMethod(a: Int, b: Int): Int = a * b

val multiplyFunction: (Int, Int) => Int = (a, b) => a * b

multiplyMethod(2, 3)

multiplyFunction(2, 3)


val nums = (1 to 5).toList

nums.map(x => x * x)

nums.map(x => x * 3)

nums.map(x => x % 2 == 0)

val fn1: (Int, Int) => Int = (a, b) => a + b

val fn2 = new Function2[Int, Int, Int] {
  override def apply(a: Int, b: Int) = a + b
}

fn1(2, 3)
fn1.apply(2, 3)
fn2(2, 3)
fn2.apply(2, 3)

val fn1curried = fn1.curried
fn1curried(2)(3)

val fn1tupled = fn1.tupled
val tup = (2, 3)

// fn1(tup) // won't compile

fn1tupled(tup)
