package LinkedList

/**
  * Created by AShrivastava on 2/4/2020.
  */
object PartitionLIst {

 /* def partition(head: ListNode, x: Int): ListNode = {

    val before_head:ListNode = new ListNode()
    // var  before_head.x = 0
    val after_head:ListNode = new ListNode()
    //val  after_head.x = 0
    var before:ListNode = before_head
    var after:ListNode = after_head
    var nhead = head

    while( nhead != null){

      //if origingal list is leas then x
      if(nhead.x < x){

        before.next = nhead
        before = before.next
      }    else{

        after.next = nhead
        after = after.next
      }
      // move ahead in the original list

      nhead = nhead.next

    }
    // Last node of "after" list would also be ending node of the reformed list
    after.next = null

    // Once all the nodes are correctly assigned to the two lists,
    // combine them to form a single list which would be returned.
    before.next = after_head.next

    return before_head.next

  }
*/
  /*

  object Solution {
    def partition(head: ListNode, x: Int): ListNode = {
        Option(head) match {
            case None => head
            case _ => {
                val ldump = new ListNode(0)
                val gdump = new ListNode(0)
                var lnext = ldump
                var gnext = gdump
                var nHead = head
                while (nHead != null) {
                    if (nHead.x < x) {
                        lnext.next = nHead
                        lnext = nHead
                    } else {
                        gnext.next = nHead
                        gnext = nHead
                    }
                    nHead = nHead.next
                }
                gnext.next = null
                lnext.next = gdump.next
                ldump.next
            }
        }
    }
}
   */

}
