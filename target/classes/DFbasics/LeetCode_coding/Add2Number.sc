//add numbers from linked list

/*


1) set tw opointerone for each input.Create head of new list
2)add values of current pointers
3)check if there is carry,add 1
4)check if sum > =10,if it is ,mod it and set carry flag =true
5)move pointers forward
6)after loop,check if carry is true,if it is ,add additional node to result list
7) return result list

time complexoty -O(m+n)
 */

//without custom list recursive
def addTwoNumbers(l1: List[Int], l2: List[Int]): List[Int] = {
  def addWithCarry(lists: (List[Int], List[Int]), carry: Int) = lists match {
    case (Nil, Nil) => if (carry == 0) Nil else List(carry)
    case (x :: xtail, Nil) => addHeads(x, 0, carry, (xtail, Nil))
    case (Nil, y :: ytail) => addHeads(0, y, carry, (Nil, ytail))
    case (x :: xtail, y :: ytail) => addHeads(x, y, carry, (xtail, ytail))
  }

  def addHeads(x: Int, y: Int, carry: Int, tails: (List[Int], List[Int])): List[Int] = {
    println(s"x...$x")
    println(s"y...$y")
    val sum = x + y + carry
    println(s"sum...$sum")
    println(s"sum% 10...${sum% 10}")
    println(s"sum / 10...${sum / 10}")
    sum % 10 :: addWithCarry(tails, sum / 10)
  }
addWithCarry((l1, l2), 0)
}




val l1 =List(2,4,3)
val l2 = List[Int](5,6,4)

addTwoNumbers(l1,l2)

/*

object ListNode {
  def apply(x: Int, next: ListNode): ListNode = {
    val n = new ListNode(x)
    n.next = next
    n
  }

  implicit def listnode2list(x: ListNode): List[Int] = x match {
    case null => Nil
    case n => n.x :: listnode2list(n.next)
  }

  implicit def list2listnode(l: List[Int]): ListNode = l match {
    case head :: tail => ListNode(head, list2listnode(tail))
    case Nil => null
  }
}

object Solution {
  import ListNode.{list2listnode, listnode2list}

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = addTwoNumbers(l1, l2, 0)

  def addTwoNumbers(l1: List[Int], l2: List[Int], c: Int): List[Int] = (l1, l2, c) match {
    case (Nil, Nil, 0) => Nil
    case (Nil, Nil, 1) => List(1)
    case (h1 :: t1, Nil, _) => (h1 + c) % 10 :: addTwoNumbers(t1, Nil, (h1 + c) / 10)
    case (Nil, h2 :: t2, _) => (h2 + c) % 10 :: addTwoNumbers(Nil, t2, (h2 + c) / 10)
    case (h1 :: t1, h2 :: t2, _) => (h1 + h2 + c) % 10 :: addTwoNumbers(t1, t2, (h1 + h2 + c) / 10)
  }
}

/*

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

      val dummyHead = new ListNode(0)
      var cur = dummyHead
      var a = l1
      var b = l2
      var carry = 0

      while(a != null || b != null) {

        val t1 = if(a != null) a._x else 0
        val t2 = if(b != null) b._x else 0
        val tmp = t1 + t2 + carry
        carry = tmp / 10
        cur.next = new ListNode(tmp % 10)
        cur = cur.next
        if(a != null) a = a.next
        if(b != null) b = b.next
      }
      if(carry > 0) cur.next = new ListNode(carry)
      dummyHead.next
    }


    //Not using ListNode in order to utilize scala pattern matching
    def addTwoNumbersRecur(l1: List[Int], l2: List[Int]): List[Int] = {

      def addTwo(a: List[Int], b: List[Int], carry: Int): List[Int] = (a, b) match {
        case (Nil, Nil) => {
          if(carry > 0) List(carry) else Nil
        }
        case (a :: atail, Nil) => {
          val sum = a + carry
          sum  % 10 :: addTwo(atail, Nil,  sum / 10)
        }
        case (Nil, b:: btail) => {
          val sum = b + carry
          sum  % 10 :: addTwo(Nil, btail,  sum / 10)
        }
        case (a:: atail, b:: btail) => {
          val sum = a + b + carry
          sum  % 10 :: addTwo(atail, btail,  sum / 10)
        }
      }
      addTwo(l1, l2, 0)
    }
 */
 */

