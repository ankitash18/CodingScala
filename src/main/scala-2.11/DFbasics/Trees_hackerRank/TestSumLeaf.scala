package DFbasics.Trees_hackerRank

/**
  * Created by AShrivastava on 1/28/2020.
  */
object TestSumLeaf extends  App{

  val tree = new SUMLeafTree

  tree.root = new Node()
  tree.root.data =1
  tree.root.leftchild = new Node()
  tree.root.leftchild.data =2
  tree.root.rightchild = new Node()
  tree.root.rightchild.data = 3
  tree.root.leftchild.leftchild = new Node()
  tree.root.leftchild.leftchild.data =4
  tree.root.leftchild.rightchild = new Node()
  tree.root.leftchild.rightchild.data =5


  // variable to store sum of leaf nodes
  //var sum = 0;
  println(tree.leafsum(tree.root))
  //println(sum)

}
