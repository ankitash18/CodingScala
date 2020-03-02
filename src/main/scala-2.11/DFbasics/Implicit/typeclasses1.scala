package DFbasics.Implicit

import DFbasics.Implicit.Typeclasses.User

/**
  * Created by AShrivastava on 12/28/2019.
  */
object typeclasses1 extends App{


  trait Equal[T]{
    def apply(a:T,b:T):Boolean
  }

  implicit  object nameequal extends Equal[User]{
    override def apply(a: User, b: User): Boolean =  a.name == b.name
  }

  object fullequal extends  Equal[User]{

    override def apply(a: User, b: User): Boolean = a.name ==b.name && a.email == b.email
  }

  object Equal{
    def apply[T](a:T,b:T)(implicit  equalizer:Equal[T]) :Boolean=
      equalizer.apply(a,b)
  }

  val john = User("john",32,"john@rockthejvm.com")
  val john1 = User("john",32,"john1@rockthejvm.com")

  println(Equal.apply(john,john1)) //adhoc ploymorphsm


}
