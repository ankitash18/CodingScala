import scala.collection.mutable
import scala.collection.mutable.Stack

val stack = new mutable.Stack[Int]()

val minstack = new mutable.Stack[Int]()

def pop():Int ={
  stack.pop
  minstack.pop
}

def push1(x:Int): Unit ={
  stack.push(x)
  //var min = x
  println(minstack.isEmpty)
  if(minstack.isEmpty || minstack.top >= x){
    println("here...")
    minstack.push(x)
  }

}

def top():Int ={
  stack.top
  minstack.top
}

def getmin():Int={
  return minstack.top
}

push1(2)
stack.top
minstack.top
stack.push(1)
stack.push(3)
stack.push(4)
stack.push(5)
//stack.top
//getmin()