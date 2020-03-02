/*
1) find sum of all element in individual stacks
2)if the sum of all three stacks are same,then this is the maximum sum
3)else remove the tol element of the stack having maximum sum amng three stacks.repea stpes 1 n 2


 */

import scala.collection.mutable
import util.control.Breaks._
import scala.collection.mutable.Stack

def maxsumstack(stack1:Stack[Int],stack2:Stack[Int],stack3:Stack[Int]) :Int= {

  val n1 = stack1.length
  val n2 = stack2.length
  val n3 = stack3.length


  var sk1 = new Stack[Int]()
  var sk2 = new Stack[Int]()
  var sk3 = new Stack[Int]()

  var sk1totalheight = 0
  var sk2totalheight = 0
  var sk3totalheight = 0

  //pusking consolidated hegiht into the stack instrad of individual cylinder height

  for(i <- n1-1 to 0 by -1){
    sk1totalheight += stack1(i)
    sk1.push(sk1totalheight)
  }

  for(i <- n2-1 to 0 by -1){
    sk2totalheight += stack2(i)
    sk2.push(sk2totalheight)
  }

  for(i <- n3-1 to 0 by -1){
    sk3totalheight += stack3(i)
    sk3.push(sk3totalheight)
  }

  //as given in question,first element is top of sequence
  var ans =0
  while({
       true
  }) {

    sk1totalheight = sk1.top
    sk2totalheight = sk2.top
    sk3totalheight = sk3.top

    println(s"her1 $sk1totalheight")

    //if any stack is empty
    if (sk1.isEmpty || sk2.isEmpty || sk3.isEmpty) {
      println(s"here1")
      ans = 0

    }



    //if sum of all three stacks are equal

    else if(sk1totalheight == sk2totalheight && sk2totalheight == sk3totalheight){
      println(s"here2 $sk1totalheight")
      ans = sk1totalheight
      return ans
    }



    //finding the stack with maximum sum and removing its element

    else if(sk1totalheight >= sk2totalheight && sk1totalheight >= sk3totalheight) {
      println(s"here3 $sk1totalheight")
      sk1.pop
    }
    else if(sk2totalheight >=  sk3totalheight && sk2totalheight >= sk1totalheight) {
      println(s"here4 $sk2totalheight")
      sk2.pop
    }
    else (sk3totalheight >=  sk1totalheight && sk3totalheight >= sk2totalheight)
    println(s"here5 $sk3totalheight")
    sk3.pop

  }
  ans
}

val stk1= Stack[Int](3,2,1,1,1)
val stk2= Stack[Int] (4,3,2)
val stk3= Stack[Int] (1,1,4,1)


maxsumstack(stk1,stk2,stk3)