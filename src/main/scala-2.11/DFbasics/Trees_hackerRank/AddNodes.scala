package DFbasics.Trees_hackerRank

/**
  * Created by AShrivastava on 1/28/2020.
  */
object AddNodes extends App{

  val tree = new Add_Binary_tree

  tree.root = new Node()
  tree.root.data =1
  tree.root.leftchild = new Node()
  tree.root.leftchild.data =1
  tree.root.rightchild = new Node()
  tree.root.rightchild.data = 1
  tree.root.leftchild.leftchild = new Node()
  tree.root.leftchild.leftchild.data =1
  tree.root.leftchild.rightchild = new Node()
  tree.root.leftchild.rightchild.data =1

  println("sum is..."+ tree.addnodes(tree.root))

}
