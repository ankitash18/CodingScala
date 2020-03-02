package DFbasics.DividenCOnquer

/**
  * Created by AShrivastava on 7/22/2019.
  */
class ArithmeicGenerator(start:Int,diff:Int) extends  SequenceGenerator {


  override def generate(total: Int): List[Int] = {

//Imperatvie way of writing
  /*  val sequence  = Array.fill(total)(0)

    var x = start

    for (n <- 0 until total) {

      sequence(n) = x
      x += diff

    }
    sequence.toList
*/

  // functinal way

    (0 until total)
      .map(n => start + n*diff).toList

  }
}
