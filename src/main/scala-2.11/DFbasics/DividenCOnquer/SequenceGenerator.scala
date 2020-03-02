package DFbasics.DividenCOnquer

/**
  * Created by AShrivastava on 7/22/2019.
  */
trait SequenceGenerator {

  def generate(total:Int):List[Int]

  def generatstr(total:Int):String=generate(total).mkString(", ")

}
