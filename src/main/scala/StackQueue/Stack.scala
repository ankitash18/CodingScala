package StackQueue

/**
  * Created by AShrivastava on 12/25/2019.
  */
trait Stack[A] {

  def push(a:A):Unit //add elelemt ot stack

  def pop():A //gives backthe elemenr of A rtype and remoe it from top of stack

  def peek:A //only gives back the top element ,dosnt not remove

  def isEmpty:Boolean


}
