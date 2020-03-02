package DFbasics.Trees_hackerRank

import scala.collection.mutable

/**
  * Created by AShrivastava on 1/30/2020.
  **
  *1) Create an empty stack S.
  *2) Initialize current node as root
  *3) Push the current node to S and set current = current->left until current is NULL
  *4) If current is NULL and stack is not empty then
  *a) Pop the top item from stack.
  *b) Print the popped item, set current = popped_item->right
  *c) Go to step 3.
  *5) If current is NULL and stack is empty then we are done.
  */
class InroderTravese {

  val root:Node =null

  var stack1 = new mutable.Stack[Int]

  var curr:Node =root
  // traverse the tree

  while (curr != null || stack1.size > 0)
  {

    /* Reach the left most Node of the
    curr Node */
    while (curr !=  null)
    {
      /* place pointer to a tree node on
         the stack before traversing
        the node's left subtree */
      stack1.push(curr.data)
      curr = curr.leftchild
    }

    /* Current must be NULL at this point */
    curr.data = stack1.pop

   print(curr.data + " ")

    /* we have visited the node and its
       left subtree.  Now, it's right
       subtree's turn */
    curr = curr.rightchild
  }

  /*

  /**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def inorderTraversal(root: TreeNode): List[Int] = {
        if (root == null) {
            return Nil
        }
        inorderTraversal(root.left) ::: List(root.value) ::: inorderTraversal(root.right)
    }
}

object Solution {
    def inorderTraversal(root: TreeNode): List[Int] = {
        var rst: List[Int] = List()
        var stack: List[TreeNode] = List()
        var node = root
        while (node != null || !stack.isEmpty) {
            while (node != null) {
                stack = stack :+ node
                node = node.left
            }
            val nd = stack.last
            rst = rst :+ nd.value
            stack = stack.take(stack.length-1)
            node = nd.right
        }
        rst
    }
}


  }

   */

}
