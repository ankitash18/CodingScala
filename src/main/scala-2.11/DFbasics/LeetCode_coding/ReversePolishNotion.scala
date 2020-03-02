package DFbasics.LeetCode_coding

import scala.collection.mutable.Stack

/**
  * Created by AShrivastava on 2/2/2020.
  * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
  **
  *Valid operators are +, -, *, /. Each operand may be an integer or another expression.
  **
  *Note:
  **
  *Division between two integers should truncate toward zero.
*The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
  *
  */
object ReversePolishNotion extends App{

  def evalRPN(tokens: Array[String]):Int ={

    val stack = new Stack[Int]()

    var val1 = 0
    var val2 = 0

    for (i <- 0 to tokens.length-1){

      val token = tokens(i)

       token  match {

         case "+" => stack.push(stack.pop + stack.pop)
         case "-" =>
            {
              val1 = stack.pop
              val2 = stack.pop
              stack.push(val2-val1)
            }
         case "*" => stack.push(stack.pop * stack.pop)
         case "/" =>  {
           val1 = stack.pop
           val2 = stack.pop
           stack.push(val2/val1)
         }
         case _ => stack.push(token.toInt)

      }
    }
    return stack.pop

  }

  val a =Array("2","1","+","3","*")
 println( evalRPN(a))

}