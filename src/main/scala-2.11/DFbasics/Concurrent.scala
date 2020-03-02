package DFbasics

/**
  * Created by AShrivastava on 7/15/2019.
  */
object Concurrent extends App {

  /*--------------------------------------------------------
		      Regular Threads
--------------------------------------------------------*/
  import scala.concurrent._

  //Simple thread run
  val simpleThread = new Thread(new Runnable {
    def run() {
      println("This is a simple thread")
    }
  })
  simpleThread.run()

}
