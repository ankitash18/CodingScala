package DFbasics.Implicit

import DFbasics.Implicit.Typeclasses.User

/**
  * Created by AShrivastava on 12/27/2019.
  */
object Typeclasses extends  App{

  trait HTMLwritable {
    def tohtml:String
  }

  case class User(name:String,age:Int,email:String) extends HTMLwritable{
    override def tohtml:String =s" <div>$name ($age  yo) <a href=$email/> </div>"
  }




  //option2 -pattenr matching
   object HTMLserialize{
    def serializetohtml(value:Any):Unit =value match {
      case User(n, a, e) =>
      //case java.util.date =>
      case _ =>
    }

  }
 //type class - can work on any type
  trait  HTMLserializer[T]{
    def serialize(value:T):String
  }

  implicit  object userserializer extends HTMLserializer[User]{
    def serialize(user:User):String =s" <div>${user.name} (${user.age}  yo) <a href=${user.email}/> </div>"

  }


  val john = User("john",32,"john@rockthejvm.com")
  val john1 = User("john",32,"john1@rockthejvm.com")
  println(userserializer.serialize(john))

  /*

  implement a equal type class tha can compare any type
   */

  trait Equal[T]{
    def apply(a:T,b:T):Boolean
  }

  implicit  object nameequal extends Equal[User]{
    override def apply(a: User, b: User): Boolean =  a.name == b.name
  }

  object fullequal extends  Equal[User]{

    override def apply(a: User, b: User): Boolean = a.name ==b.name && a.email == b.email
  }

  println(nameequal(john,john1))
  println(fullequal(john,john1))

  //implement implicit with type class

  //type class
  trait MYTypeClasstemplate[T]{
    def action(value:T):String
  }
  object MYTypeClasstemplate{
    def apply[T](implicit instance:MYTypeClasstemplate[T])=instance
  }

  object HTMLserializer{

    def serialize[T](value:T)(implicit  serializer:HTMLserializer[T]):String=
      serializer.serialize(value)
  }

  implicit object  IntSerializer extends HTMLserializer[Int]{

    override def serialize(value: Int): String = s"<div style: color=blue>$value</div>"
  }

  println(HTMLserializer.serialize(value=42))
  println(HTMLserializer.serialize(john))

  /*
  exercise = implement the type class  pattern for the equLITY
   */

  object Equal{
    def apply[T](a:T,b:T)(implicit  equalizer:Equal[T]) :Boolean=
      equalizer.apply(a,b)
  }

  println(Equal.apply(john,john1)) //adhoc ploymorphsm
}


