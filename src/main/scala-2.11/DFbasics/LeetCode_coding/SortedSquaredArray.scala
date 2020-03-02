package DFbasics.LeetCode_coding

/**
  * Created by AShrivastava on 2/2/2020.
  */
object SortedSquaredArray {

  def sortarray(a:Array[Int]):Array[Int]={


    for(i <- 0 to a.length-1){
      a(i) *= a(i)
    }

    val b = a.sorted

    b
  }

}
