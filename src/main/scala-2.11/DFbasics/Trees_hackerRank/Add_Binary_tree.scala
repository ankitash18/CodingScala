package DFbasics.Trees_hackerRank

/**
  * Created by AShrivastava on 1/28/2020.
  */
class Add_Binary_tree {

  var root :Node=null
  var sumleft =0
  var sumright =0
  var sum =0

  def addnodes(root:Node):Int ={

     var sum:Int =0
    if(root ==null) {
      println("tree is empty")
      return 0
    }

   if(root.leftchild != null){
     sumleft = addnodes(root.leftchild)
   }

    if(root.rightchild != null){
      sumright = addnodes(root.rightchild)
    }

    //Calculate the sum of all nodes by adding sumLeft, sumRight and root node's data

    sum = root.data + sumleft + sumright
    sum

  }

}
