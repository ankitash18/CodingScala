package DFbasics.DividenCOnquer

/**
  * Created by AShrivastava on 7/22/2019.
  */
object Launcher {

  def main(args:Array[String]): Unit ={

    val ag=new ArithmeicGenerator(0,5)
    println(ag.generatstr(10))


    val fgenerator =new FibonicciFenerator()
    println(fgenerator.generatstr(10))
  }

}
