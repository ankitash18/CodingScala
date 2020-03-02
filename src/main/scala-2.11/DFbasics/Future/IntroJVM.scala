package DFbasics.Future

/**
  * Created by AShrivastava on 1/12/2020.
  */
object IntroJVM extends App{

  /*
  in java.lang
  interfce -Runnable ,method calls run
  traits in scaa
   */
 //jv mthread

  val runnable = new Runnable {
    override def run(): Unit = println("run in parallel")
  }

  /*val athread = new Thread(new Runnable {
    override def run(): Unit = println("run in parallel")
  })

  */

  val athread = new Thread(runnable)


  athread.start() //it creates a jvm thread  => OS thrd gives signAL TO JVM TO start a jvm thrad
   athread.join() //blocks untill thread finised running


  val threadhello = new Thread(new Runnable {
    override def run(): Unit = println("run in parallel")
    (1 to 5).foreach(_ => println("hello"))
  })

  val threadbye = new Thread(new Runnable {
    override def run(): Unit = println("run in parallel")
    (1 to 5).foreach(_ => println("goodbye"))
  })

  threadbye.start()

}
