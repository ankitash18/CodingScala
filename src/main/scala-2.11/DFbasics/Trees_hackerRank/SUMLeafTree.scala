package DFbasics.Trees_hackerRank

/**
  * Created by AShrivastava on 1/28/2020.
  */
class SUMLeafTree {

  var root:Node= null
  var sum = 0

  // utility function which calculates
  // sum of all leaf nodes

  def leafsum(root:Node):Int ={

    if(root ==null) {
      return 0
    }
    // add root data to sum if
    // root is a leaf node

    if(root.leftchild ==null && root.rightchild ==null) {
      sum += root.data
    }

    if(root.leftchild != null) {
      sum += leafsum(root.leftchild)
    }
    if(root.rightchild !=null) {
      sum += leafsum(root.rightchild)
    }

  sum
  }

}
