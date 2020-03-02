/*
Print out Odd Numbers from 1-99


 */

def printOdds(min: Int, max: Int): List[Int] = {
  val range = new Range(min, max, 1)

  val l = range.toList

  l.filter(_%2 == 1)
  //range.toList filter (_ % 2 == 1)
}

printOdds(1,99)

//Find largest int value in an int array


def max(n:Array[Int]):Int={

  var max = 0

  n.foreach{

    elem => if(max < elem) max = elem else max = max

  }

  max
}

val n = Array[Int](9,1,3,5,6,7)

max(n)