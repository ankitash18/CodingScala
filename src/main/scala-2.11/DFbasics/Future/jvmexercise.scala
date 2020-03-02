package DFbasics.Future



/*

The terms are often used interchangably and I have seen them defined in different ways. So I can just give you the definitions that I like and how I use them in my books. When you multithread a program you get concurrency. At the very least, it acts like two things are happening at once. However, if your machine has a single core, it is really only one thing happening at a time, but two or more threads can swap out quickly so that the user thinks more than one thing is happening at a time. Parallelism is when you have concurrency and your hardware actually supports two or more things happening at the same time.

Concurrency can improve user experience. It can make things more reactive even if you don't have better hardware. Parallelism is required if you actually want to make things happen faster.
 */

/**
  * Created by AShrivastava on 1/11/2020.
  */
object jvmexercise extends App {

  /*

  change notify to notifyall and seete changes
  create a deadlock- were one thrad or multiple thread block each other and they cannot continue
  create a live lock - also a situation where thred cannot continue but as oppsoed to deadlock livelock implies that thrads yeild execution to each other in such a way that nobody can continue.
  so threads are active,they r not blocked but they cannot contine
   */

  def testnotifyall(): Unit = {

    val bell = new Object


    /*(1 to 10).foreach(i => new Thread(() => {
      bell.synchronized{
        println(s"thread $i waiting")
        bell.wait()
        println(s" thread $i wokeup")
      }
    }).start())

    new Thread(() => {
      Thread.sleep(2000)
      println("announcer")
      bell.synchronized{
        bell.notifyAll()
      }
    }).start()
  }
*/
    testnotifyall()

  }
}