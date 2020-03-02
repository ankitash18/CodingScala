import scala.collection.mutable.ListBuffer

/**
  * Created by AShrivastava on 7/14/2019.
  */
object Intersection {

  def intersection(x:List[Int],y:List[Int]):List[Int]={

    //1st method

     val inter=ListBuffer[ Int]() //to write it better ,get rid of mutable list
    for(i <- x) {
      for(j <- y){
        if(i ==j)
          inter += i
      }
    }
   inter.toList


    //2nd method

    x.filter(i => y.contains(i))

    //3rd method
    x.intersect(y)

  }

  def main(args:Array[String]): Unit ={

    val x:List[Int] = List(1,2,3,4,5)

    val y:List[Int] = List(4,5,6)

    println(intersection(x,y))
  }

}
