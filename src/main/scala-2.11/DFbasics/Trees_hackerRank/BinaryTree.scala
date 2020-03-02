package DFbasics.Trees_hackerRank

/**
  * Created by AShrivastava on 1/27/2020.
  */
class BinaryTree {

  var root:Node =null

  def fndheight(node:Node):Int = {
    //Check whether tree is empty

    if(node == null){
      println("root is empty")
      return 0

    }
    var leftheight = fndheight(node.leftchild)
    var rightheight = fndheight(node.rightchild)
    //Calculate the height of left subtree

    //Compare height of left subtree and right subtree
    //and store maximum of two in variable max

    var height = Math.max(leftheight,rightheight)

    //Calculate the total height of tree by adding height of root

    return (height+1)


  }

}
