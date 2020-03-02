// balanced brackets
//same number of bracekts in same format

//[{()}] -balanced bracket




//val s1=s.replace("()","")

//println(s1)
import scala.collection.mutable
import scala.collection.mutable.Stack



def isBalanced(s:String):String ={

val stk = new Stack[Char]()

  for(i <- 0 to s.length-1){
    if(s(i) =='(' || s(i) == '{'  || s(i) =='[') {
    //  println(s"here///$s(i)")
      stk.push(s(i))
    }
    else if(!stk.isEmpty && s(i) ==')' && stk.top=='(')
      stk.pop()

    else if(!stk.isEmpty && s(i) =='}' && stk.top=='{')
      stk.pop()

    else if(!stk.isEmpty && s(i) == ']' && stk.top== '[')
      stk.pop()

    else
      stk.push(s(i))
  }

  println(s"stack $stk")
  if(stk.isEmpty) {
    println("yes")
    "YES"
  }
  else {
    println("no")
    "NO"
  }

}

var s:String ="{{}"

isBalanced(s)


// queue-a tale of two stack
//push like stack
//pop,peek like queue

import scala.collection.mutable



val newstack=new Stack[Int]()
val oldstack=new Stack[Int]()

def enqueue(data:Int)={
  newstack.push(data)

}


def dequeue():Int={

  if(oldstack.isEmpty){
    while(!newstack.isEmpty){
      oldstack.push(newstack.pop())
    }
  }
  val ret = oldstack.pop()
  ret
}

def peek():Int={

  if(oldstack.isEmpty){
    while(!newstack.isEmpty){
      println(s"here...${newstack.pop()}")
      oldstack.push(newstack.pop())
    }
  }
  println(s"old stack...$oldstack")
  val ret = oldstack.top
  ret
}

enqueue(1)
enqueue(2)

enqueue(3)
enqueue(4)
enqueue(5)

dequeue()
dequeue()
dequeue()
peek()
dequeue()
peek()
dequeue()