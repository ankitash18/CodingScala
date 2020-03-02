package DFbasics.Trees_hackerRank

/**
  * Created by AShrivastava on 1/30/2020.
  */
class IsBinaryTree {

  var root:Node= null

  def isBinarySearchTree(root: Node): Boolean = {

    isValidBst(root, Long.MinValue, Long.MaxValue)
  }

  def isValidBst(root: Node, min: Long, max: Long): Boolean = {
    if(root == null) true
    else root.data > min && root.data < max &&
      isValidBst(root.leftchild, min, root.data) &&
      isValidBst(root.rightchild, root.data, max)
  }


}

/*
In order traversal

object Solution {
    var prev: TreeNode = null
    def isValidBST(root: TreeNode): Boolean = {
        prev = null
        validate(root)
    }

    def validate(root: TreeNode): Boolean = {
        if(root == null) return true
        if(!validate(root.left)) return false
        if(prev != null && prev.value >= root.value) return false
        prev = root
        return validate(root.right)
    }
}
 use nulll for max_int and minint
def isValidBST(root: Nothing): Boolean =  { return helper(root, null, null)
}

    def helper(root: Nothing, min: Integer, max: Integer): Boolean =  { if (root == null)  { return true}
if ((min != null && root.`val` <= min) || (max != null && root.`val` >= max))  { return false}
return helper(root.left, min, root.`val`) && helper(root.right, root.`val`, max)
}
 */
