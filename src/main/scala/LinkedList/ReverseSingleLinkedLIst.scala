package LinkedList

/**
  * Created by AShrivastava on 2/4/2020.
  * iterative solution
  */
object ReverseSingleLinkedLIst extends App {
   class ListNode(var data:Int,var next:ListNode)

  private var head:ListNode =null
  def reverseList(head: ListNode): ListNode = {

    var prev :ListNode = null
    var next :ListNode =null
    var curr :ListNode = head

    while(curr !=null){

      next = curr.next
      curr.next = prev
      prev = curr
      curr = next
    }
    val newhead:ListNode = prev
    return newhead
  }

}
