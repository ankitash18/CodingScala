package LinkedList

import StackQueue.Stack

/**
  * Created by AShrivastava on 12/25/2019.
  */
class ListStack[A] extends Stack[A]{

  private case class Node(data:A,next:Node)

  private var top:Node =null

  def push(a:A):Unit ={

  top =  new Node(a,top)
  }

  def pop():A ={

    val ret =top.data

    top = top.next
    ret
  }

  def peek:A = top.data

  def isEmpty:Boolean = top ==null


}
