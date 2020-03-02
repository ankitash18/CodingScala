package DFbasics.DividenCOnquer

/**
  * Created by AShrivastava on 7/22/2019.
  */
class FibonicciFenerator  extends  SequenceGenerator {

  //Imperatvie way of writing

  /* override def generate(total: Int): List[Int] = {

    val sequence = Array.fill(total)(0)
    sequence(0) = 1
    sequence(1) = 1

    for (n <- 2 until total) {

      sequence(n) = sequence(n - 1) + sequence(n - 2)

    }
    sequence.toList


    // functinal way

    // (0 until total)
    // .map(n => start + n*diff).toList


  }
  */

  // functunal way
  //to use Stream

  val streamFib:Stream[Int] = 1 #:: 1 #:: streamFib.zip(streamFib.tail).map(t => t._1+t._2)

  override def generate(total: Int): List[Int] = streamFib.take(total).toList
}



