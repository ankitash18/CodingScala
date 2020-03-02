package DFbasics.BinarySearchTree

/**
  * Created by AShrivastava on 1/2/2020.
  */
object TestBST  extends App{

  val tree = new BinaryTree

  tree.add(50)
  tree.add(25)
  tree.add(75)
  tree.add(10)
  tree.add(30)
  tree.add(60)

   tree.traverse()
}
