import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

case  class SinglyLinkedListNode(var data: Int, var next: SinglyLinkedListNode = null)

  class SinglyLinkedList(var head: SinglyLinkedListNode = null, var tail: SinglyLinkedListNode = null) {

    def insertNode(nodeData: Int) = {
      val node = new SinglyLinkedListNode(nodeData)

      if (this.head == null) {
        this.head = node
      } else {
        this.tail.next = node
      }
      this.tail = node
    }
  }

  def printSinglyLinkedList(head: SinglyLinkedListNode, sep: String, printWriter: PrintWriter) = {
    var node = head

    while (node != null) {
      printWriter.print(node.data)

      node = node.next

      if (node != null) {
        printWriter.print(sep)
      }
    }
  }

  // Complete the insertNodeAtPosition function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     data: Int
   *     next: SinglyLinkedListNode
   * }
   *
   */
  def insertNodeAtPosition(head: SinglyLinkedListNode, data: Int, position: Int): SinglyLinkedListNode = {

    if(head == null){
      val ret = new SinglyLinkedListNode(data)
      ret
    }
    else if(position == 0){
      val  head2  = new SinglyLinkedListNode(data,head.next)
      head2
    }
    else{
      var rover = head
      for(i <- 0 until position - 1)
        rover = rover.next
      rover.next =new SinglyLinkedListNode(data,rover.next)
      rover.next
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val llist = new SinglyLinkedList()

    val llistCount = stdin.readLine.trim.toInt

    for (_ <- 0 until llistCount) {
      val llistItem = stdin.readLine.trim.toInt
      llist.insertNode(llistItem)
    }

    val data = stdin.readLine.trim.toInt
    val position = stdin.readLine.trim.toInt

    val llist_head = insertNodeAtPosition(llist.head, data, position)

    printSinglyLinkedList(llist_head, " ", printWriter)
    printWriter.println()

    printWriter.close()
  }
}






