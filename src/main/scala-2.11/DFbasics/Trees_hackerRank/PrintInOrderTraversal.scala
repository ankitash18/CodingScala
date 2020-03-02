package DFbasics.Trees_hackerRank

import scala.collection.mutable.ListBuffer

/**
  * Created by AShrivastava on 2/3/2020.
  */
/*

inroder traversal gives sorted array.
go to left
print node
go to right
 */
object PrintInOrderTraversal {

  //using recursive soluton

  def inroderrec(root:Node):List[Int]={

    val result = ListBuffer[Int]()


    helper(root,result)
    return result.toList


  }

  def helper(root:Node,result:ListBuffer[Int]): Unit ={

    if(root ==null){
      null
    }

    helper(root.leftchild,result)
    result.append(root.data)
    helper(root.rightchild,result)

  }

}
