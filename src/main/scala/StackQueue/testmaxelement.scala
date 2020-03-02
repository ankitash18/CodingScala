package StackQueue

/**
  * Created by AShrivastava on 1/8/2020.
  */
object testmaxelement extends App{

  val stack = new maxelemwntStack()

  stack.push(4)
  stack.push(3)
  stack.push(9)
  stack.push(2)
  stack.push(8)

  println(s" max elemnt ${stack.getmax()}")

  stack.pop
  stack.pop
  stack.pop

  println(s" max elemnt ${stack.getmax()}")

  //println(stack.st)

}
