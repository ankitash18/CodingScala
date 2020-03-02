package DFbasics.BinarySearchTree

/**
  * Created by AShrivastava on 1/2/2020.
  */
class BinaryTree {


  //node -> key(data)
  //left child,right child

  var root:Node =null


  def add(data:Int): Unit ={

  var  nodetoadd = new Node()
    nodetoadd.data = data

    println(s"data is////${nodetoadd.data}")

    if(root == null){
     // println(s"inside root ///$data")
      root = nodetoadd
    }

     var  traversingnode = root
    traverseandAddnode(root,nodetoadd)

      //if data < node ,traverse left

  }

  def traverseandAddnode(node:Node,nodetoadd:Node): Unit ={

    if(nodetoadd.data < node.data){
     // println(s"inside left node ///${nodetoadd.data}")
       if(node.leftchild == null){
         nodetoadd.parent = node
         node.leftchild = nodetoadd
       }
       else {
      //   println(s"inside rcursive left node ///${nodetoadd.data}")
         traverseandAddnode(node.leftchild, nodetoadd)
       }
    }
      else if(nodetoadd.data > node.data) {
    //  println(s"inside right node ///${nodetoadd.data}")
      if (node.rightchild == null) {
        nodetoadd.parent = node
        node.rightchild = nodetoadd
      }
      else {
      //  println(s"inside recursive right node ///${nodetoadd.data}")
        traverseandAddnode(node.rightchild, nodetoadd)
      }
    }
  }

  def delete(data :Int):Boolean ={

    //case 1 -node has no childern
    // case 2- node has one child
    //case3 - node is having 2 child

     val nodedeleted =find(data)
      if(nodedeleted !=null)
      {
          //case 1
        if(nodedeleted.leftchild ==null && nodedeleted.rightchild ==null)
          {
            deletecase1(nodedeleted)
          }
        //case 3- if bdelete node has both children
        else if(nodedeleted.leftchild !=null  && nodedeleted.leftchild !=null)
          {
            deletecase3(nodedeleted)
          }
        //case 2  whre left child shoyld be delelted
        else if(nodedeleted.leftchild !=null )
          {
           deletecase2(nodedeleted)
          }
        //case 2  whre right child shoyld be delelted
        else if(nodedeleted.leftchild !=null )
        {
          deletecase2(nodedeleted)
        }

      }

    return false
  }

   def deletecase1(nodedeleted:Node){

     //check if the node to be deleted is the left or right child of  the parent of thr node
      if(nodedeleted.parent.leftchild == nodedeleted){
        nodedeleted.parent.leftchild =null
      }
      else if(nodedeleted.parent.rightchild == nodedeleted){
        nodedeleted.parent.rightchild =null
      }
    }

  def deletecase2(nodedeleted: Node): Unit ={
         //   50
    //   25        75
    //10         65   80
//25needs to be deleted

    if(nodedeleted.parent.leftchild == nodedeleted)
      {
        if(nodedeleted.leftchild !=null)
        {
          nodedeleted.parent.leftchild = nodedeleted.leftchild
        }
        else if (nodedeleted.rightchild !=null)
        {
          nodedeleted.parent.rightchild = nodedeleted.rightchild
        }

      }
      else if(nodedeleted.parent.rightchild == nodedeleted)
      {
          if(nodedeleted.leftchild !=null)
          {
            nodedeleted.parent.rightchild = nodedeleted.leftchild
          }
          else if (nodedeleted.rightchild !=null)
          {
            nodedeleted.parent.rightchild = nodedeleted.rightchild
          }
      }

  }

  def deletecase3(nodedeleted:Node)={

    var minnode = mintraversal(nodedeleted.rightchild)

      //delete minmim node
       deletecase2(minnode)
    minnode.parent = nodedeleted.parent
    minnode.leftchild = nodedeleted.leftchild
    minnode.rightchild = nodedeleted.rightchild

    if(nodedeleted.parent == null){
      root =minnode
    }
    else {
      if (nodedeleted.parent.leftchild == nodedeleted) {

        nodedeleted.parent.leftchild = minnode
      }
      else if (nodedeleted.parent.rightchild == nodedeleted) {

        nodedeleted.parent.rightchild = minnode
      }
    }

  }
   //get minimum node from sucessor -
  def mintraversal(node:Node): Node =
  {
    if(node.leftchild ==null)
    {
      node
    }
    return mintraversal(node.leftchild)
  }


  def find(data:Int):Node={
  if(root != null){
    var  nodetofind = new Node()
         nodetofind.data = data
         return findNode(root,nodetofind)
  }
     null
  }

  def findNode(search:Node,node:Node):Node ={

    if(search == null) {
       null
    }

    if(search.data ==node.data){
      search
    }
    else
      {

        var returnnode = findNode(search.leftchild,node)

        if(returnnode == null)
          {
            var returnnode = findNode(search.rightchild,node)
          }
        returnnode
      }


  }

   def traverse(): Unit = {

     //pre -order traversal,post order,in order
     if (root != null) {
       var nodetotraverse = root
       if (nodetotraverse.leftchild == null && nodetotraverse.rightchild == null) {
         println(nodetotraverse.data)
       }
       else {

       //  preordertraverse(nodetotraverse)
         inordertraverse(nodetotraverse)
         //println(nodetotraverse.data)
         //postordertraverse(nodetotraverse.data)

       }
     }
   }

   def  inordertraverse(node:Node){

     if(node.leftchild != null){
       inordertraverse(node.leftchild)
     }
       //priniting root
       println(node.data)
       if(node.rightchild !=null){
         inordertraverse(node.rightchild)
       }


     }
  def  preordertraverse(node:Node){


    println(node.data) //priniting root first
    if(node.leftchild != null){
      preordertraverse(node.leftchild)
    }

    if(node.rightchild !=null){
      preordertraverse(node.rightchild)
    }


  }
  def  postordertraverse(node:Node){



    if(node.leftchild != null){
      postordertraverse(node.leftchild)
    }

    if(node.rightchild !=null){
      postordertraverse(node.rightchild)
    }

    println(node.data) //priniting root first


  }


}
