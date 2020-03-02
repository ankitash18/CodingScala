case class Bag[A](content: A) {
  def map[B](f: A => B): Bag[B] = Bag(f(content))
  def flatMap[B](f: A => Bag[B]): Bag[B] = f(content)

  def flatten = content

}

case class Sugar(weight: Double)
// the guy who is expert at making sugar half
def half = (sugar: Sugar) => Sugar(sugar.weight / 2)
val sugarBag: Bag[Sugar] = Bag(Sugar(1)) //Bag functor of type sugar
// map is the guy in our story who can perform operations
// by unwrapping the bag and then calling respective function
// and wraps the content back in a bag
val halfSugarBag: Bag[Sugar] = sugarBag.map(sugar => half(sugar))

def double = (sugar: Sugar) => Bag(Sugar(sugar.weight * 2))
val doubleSugarBag = sugarBag.map(sugar => double(sugar)).flatten
//or
val doubleSugarBag1 = sugarBag.flatMap(sugar => double(sugar))

//option function

val x: Option[Int] = Some(1)
val y: Int = 2
val m: Int = 2
val z = if(x.isDefined) Some((x.get + y) * m) else None


val z1 = x.map(a => (a+y) * m)
//or with the help of associative law
val z2 = x
  .map(_ + y)
  .map(_ * m)