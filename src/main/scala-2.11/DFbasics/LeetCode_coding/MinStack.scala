package DFbasics.LeetCode_coding

/**
  * Created by AShrivastava on 2/29/2020.
  */
import scala.collection.mutable
import scala.collection.mutable.Stack
class MinStack {

  val stack = new mutable.Stack[Int]()

  val minstack = new mutable.Stack[Int]()

  def pop1(): Unit = {
    if(minstack.top == top){
      minstack.pop
    }
    stack.pop
   // minstack.pop
  }

  def push1(x: Int): Unit = {
    stack.push(x)
    //var min = x
    println(minstack.isEmpty)
    if (minstack.isEmpty || minstack.top >= x) {
      println("here...")
      minstack.push(x)
    }
  }

    def top(): Int = {
      println(stack.top)
      stack.top

    //  stack.top
      //minstack.top
    }

    def getmin(): Int = {
      println(minstack.top)
      return minstack.top
    }


}
