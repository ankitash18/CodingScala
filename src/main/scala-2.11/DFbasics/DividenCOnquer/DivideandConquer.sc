val tempdiff = Array(-13,-4,-4,5,-4,6,-9,6,-3,5,-2,7,5,5,-8,3,-2,-3,3)


// brute force algorigthm

def maxsubarray(input:Array[Int]):Int ={

  val allSums= for(i <-0 until input.length ; j <- (i+1) to input.length)
                yield  input.slice(i,j).sum

  allSums.max
}


maxsubarray(tempdiff)

//divide and conquer algoithm

val tempdiff1 = Vector(-13,-4,-4,5,-4,6,-9,6,-3,5,-2,7,5,5,-8,3,-2,-3,3)

val left = Vector(1,2,3,4)

val leftsub = for(i <- 1 to left.length)
                  yield left.takeRight(i).sum

val right = Vector(5,6,7,8)

val rightsub = for(i <- 1 to left.length)
  yield left.take(i).sum

val(x,y) = left.splitAt(left.length/2)

def maxAcross (left:Vector[Int],right:Vector[Int]):Int = {

val allleftsums = for(i <- 1 to left.length)
                          yield left.takeRight(i).sum

  val allrightsums = for(i <- 1 to right.length)
                         yield left.take(i).sum

  allleftsums.max + allrightsums.max
}


def maxsubarray1(input:Vector[Int]) :Int = input match {


  case Vector(x) => x
  case _ =>

    val (left,right) = input.splitAt(input.length/2)

    val maxleft = maxsubarray1(left)
    val maxright = maxsubarray1(right)


    val maxcross = maxAcross(left,right)


    List(maxleft,maxright,maxcross).max

}

maxsubarray1(tempdiff1)

