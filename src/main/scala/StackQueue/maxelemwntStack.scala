package StackQueue

/**
  * Created by AShrivastava on 1/8/2020.
  */
//same way min value cn be dervied
import  scala.collection.mutable.Stack
class maxelemwntStack {

  var st = Stack[Int]()
  var maxst = Stack[Int]()

  def push(data:Int): Unit ={

    var max = data

    if(!maxst.isEmpty && max < maxst.top){

      max =maxst.top
    }
    st.push(data)
    maxst.push(max)


    }



  def pop: Unit = {
    st.pop()
    maxst.pop()
  }

  def getmax() :Int={

  return maxst.top

  }

  /*
  with o(1) time m space comlxity
  In this article, a new approach is discussed that supports minimum with O(1) extra space.
  We define a variable minEle that stores the current minimum element in the stack.
  Now the interesting part is, how to handle the case when minimum element is removed.
  To handle this, we push “2x – minEle” into the stack instead of x so that previous minimum element can be retrieved using current minEle and its value stored in stack.
  Below are detailed steps and explanation of working.
   */

}
