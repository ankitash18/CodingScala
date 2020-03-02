package DFbasics.Implicit

/**
  * Created by AShrivastava on 12/27/2019.
  */
object Implicits extends App{

  println((List(1,4,3,5,2).sorted))

  //this calls scala ordering impilicts scala.predef it is automatically imported

  implicit  def reverseorderding:Ordering[Int] =Ordering.fromLessThan(_>_)

  println((List(7,6,9,5).sorted)) //override scala predef sort method

  /*

  Implicits(used as)
  -val-/var
  object
  accessor method- def with no parameter
   */

case class person(name:String,age:Int)

  val persons=List(person("stever",30),
    person("amy",25),
    person("john",66)
  )

 // println(persons.sorted)

  /*
  implicit scope
  -normal scope - local scope
  imported  scope
  companion of all type invloved in the method signature
  -List
  ordering
  all the type involved - A or any super tpe

  best practies -
  when defining an implict val
  #1
  if there is single vale possible vlaue for it

   */

  object alphaNameordering {
    implicit val alphaordering: Ordering[person] = Ordering.fromLessThan((a, b) => a.name.compareTo(b.name) < 0)
  }

  object alphaAgeordering {
    implicit val ageordering: Ordering[person] = Ordering.fromLessThan((a, b) => a.age < b.age)
  }

  import alphaAgeordering._
  println(persons.sorted)


  /*

  exercise -
  add three orderigng by three criteria for purchase
  by totalprice = most used(50%) since this is te most used,so we will put them in companion object of purchase
  by unit count =25%
  by unit price =25%
     */

  case class purchase(units:Int,price:Double)

  object purchase {
    implicit val totalpriceordering: Ordering[purchase] = Ordering.fromLessThan((a, b) => a.units * a.price < b.units * b.price)
  }

  object unitcntordering {
    implicit val unitcountordering: Ordering[purchase] = Ordering.fromLessThan(_.units < _.units)
  }

  object priceordering {
    implicit val pricecountordering: Ordering[purchase] = Ordering.fromLessThan(_.price < _.price)
  }

  val purchases =List(purchase(10,20.0),
                      purchase(5,10.0) ,
                     purchase(30,5.0)
               )

  //import priceordering._
  println(purchases.sorted)
}
