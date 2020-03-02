import scala.collection.mutable
import scala.collection.mutable.Stack

/*

reverse a string
 */

def reverse(s:String):String={

  val mystack =Stack[Char]()

 val c:Array[Char] = new Array[Char](s.length)

  val n = s.length
  for( i <- 0 to n-1 ){
    //print(s(i))
    mystack.push(s(i))
  }

  for(i <- 0 to n-1){
    c(i) = mystack.top
    mystack.pop()
  }

  c.mkString("")
}

reverse("ankita")