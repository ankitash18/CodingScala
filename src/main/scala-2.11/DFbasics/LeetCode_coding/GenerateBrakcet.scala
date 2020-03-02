package DFbasics.LeetCode_coding

import scala.collection.mutable.ListBuffer

/**
  * Created by AShrivastava on 2/2/2020.
  */
/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Approach: each time we have 2 condition : either to put left bracket or right bracket.
step1. you can put left bracket if you have left bracket left.
step 2. you can only put any right braces if you already have any left braces and left bracket should be more than right bracket for that you have to check if left bracket left should be less than right bracket left.
step 3. if both "left bracket left" and "right bracket left " is 0 , add to list and return.
 */
object GenerateBrakcet extends App {


  def generateparenthesis(n:Int):List[String]= {
    val result: ListBuffer[String] = new ListBuffer[String]()
    helper(result,"",n,n)
    println(result.toList)
    return result.toList
  }

  def helper(result:ListBuffer[String],curr:String,left:Int,right:Int): Unit ={

    println(s"right is ..$right")
    println(s"left is ..$left")
    println(s"curr is ..$curr")

    if(left < 0 || right < 0) {
      return
    }

    if(left == 0 && right == 0){
      result.append(curr)
      return
    }

    helper(result,curr + "(",left-1,right)
    helper(result,curr + ")",left,right-1)

  }

  generateparenthesis(2)

}
