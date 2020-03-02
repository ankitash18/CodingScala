package DFbasics.Trees_hackerRank

/**
  * Created by AShrivastava on 1/27/2020.
  */
//findHeight() will determine the maximum height of the binary tree
object FindHeight extends App{

  val tree = new BinaryTree

 // tree.root = new Node()
 // tree.root.data =1
 // tree.root.leftchild = new Node()
//  tree.root.leftchild.data =2
//  tree.root.rightchild = new Node()
////  tree.root.rightchild.data = 3
 // tree.root.leftchild.leftchild = new Node()
 // tree.root.leftchild.leftchild.data =4
  //tree.root.leftchild.rightchild = new Node()//tree.root.leftchild.rightchild.data =5

  println("Height of tree is : " +
    tree.fndheight(tree.root))


}
