//prgram 1-add element to list

def insertNodeAtPosition(llist: List[Int], data: Int, position: Int): List[Int] = {
  var newList = List[Int]()


  if(position ==0) {
    newList =  data :: llist
  }

 else if(position >= llist.length) {
    newList =  llist :+ data
  }

  //if(position > llist.length)
  else {
    for (i <- 0 to llist.length - 1) {

      if (i < position || i > position )
        newList = newList :+ llist(i)
     // else if (i > position
     //   newList = newList :+ llist(i)
      else
        newList = newList :+ data :+ llist(i)
    }
  }
 // println(newList.head)
  newList
}


val ls = List(16,13,7,2)

val len =ls.length

println(len)

//val ls2= 1 :: ls

//println(ls2)
insertNodeAtPosition(ls,1,3).foreach(println)

//soluton 2-

/*
def insertNodeAtPosition(head: SinglyLinkedListNode, data: Int, position: Int): SinglyLinkedListNode = {

    println(s"head..$head")

       val newnode = new SinglyLinkedListNode(data)

  if(head == null){

      val ret = new SinglyLinkedListNode(data)
      ret
    }
    else if(position == 0){
      val  head2  = new SinglyLinkedListNode(data,head.next)
      head2
    }
    else{

     // var currnode  = head
      //for(i <- 0 to position - 1){
      //  currnode = currnode.next
      //  }
      //  newnode.next = currnode.next
       // currnode.next = newnode
       // head
        var rover =head
        for(i <- 0 until position - 1)
        rover =rover.next
        rover.next =new SinglyLinkedListNode(data,rover.next)
        head
    }
    }

*/

// 2nd program - insert in double linked list in sorted order

/*

 def sortedInsert(head: DoublyLinkedListNode, data: Int, position: Int): DoublyLinkedListNode = {

 var ptr :DoublyLinkedListNode  = head
              var temp = new DoublyLinkedListNode(data)
               temp.next = null
               temp.prev = null

                    //if list if empty
                    if(head ==null){

                       // head =temp
                        return temp
                    }

                    // If node is to be inserted at 1st place
                    if( data < head.data){
                            temp.next =head
                            head.prev =temp
                            val head2 =temp
                            return head2
                                     }

                while(ptr != null){

                            //if node to be  inserted is in between
                            if(data < ptr.data){
                                temp.next = ptr
                                temp.prev = ptr.prev
                                ptr.prev.next = temp
                                ptr.prev =temp
                                return head
                                }

                            // if node is inserted at the end
                            if(ptr.next == null){
                                        temp.prev = ptr
                                        temp.next = null
                                        ptr.next = temp
                                        return head
                                        }

                                ptr = ptr.next

                            }

                        // to avoid error
                        return head

 }


 */

// 3rd - reverese the doubly linked list
//example -
//first to print the reverse of single linked list
/*private class Node(var data:Int,var next:Node)

private var head:Node =null


def reverseprint(head :Node): Unit ={

  if(head ==null) {
    return
  }
  reverseprint(head.next)
  println(s"list in reverse ...${head.data}")

}

*/

/*



 def reverse(head: DoublyLinkedListNode): DoublyLinkedListNode = {
 var temp :DoublyLinkedListNode  = null
 var current:DoublyLinkedListNode =head

 var newhead = head

     while( current!= null){

     temp = current.prev
     current.prev = current.next
     current.next = temp
     newhead = current

     current = current.prev

 }

 if(newhead != null)
 return newhead


 }



 */


/*

problem 5- detect a cycle in linked list

#              -> D \
#             /      v
# A -> B -> C         E
#            ^       /
#             \  F <-
Start: slow = A, fast = A

Loop 1: slow = B, fast = C

Loop 2: slow = C, fast = E

Loop 3: slow = D, fast = C

Loop 4: slow = E, fast = E; (slow == fast => cycle found!)

The fast pointer is skipping every other node (fast.next.next) while the slow pointer is stepping through each node one at a time (slow.next). If the fast pointer gets stuck in a cycle, we will eventually reach a point where the slow pointer "catches up" and equals the fast pointer - which can only happen if there's a cycle.


 */

/*


/**
    If a loop exists, then the fast pointer will eventually end up behind the slow pointer. The fast pointer will then catch up to the slow pointer, detecting the loop. This will always happen, no matter the size of the loop.
    Ability is the find the existence of loop,not the location of loop!!!
    **/
boolean hasCycle(Node head){
    Node slow = head;
    Node fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) return false;

        slow = slow.next;
        //the absolute distance between 2 node when looped is always reduce by one

        fast = fast.next.next;

        //The smart point is not a static check point(because it only check the static position!)
    }

    return true;

}



def hasCycle(head: Nothing): Boolean =  { var p: Nothing = head
var q: Nothing = head
while ( { p != null && q != null && q.next != null})  { p = p.next
q = q.next.next
if (p eq q)  { return true
}
}
return false
}
 */