package DFbasics.Future

object Multithreading {


  def main(args:Array[String]):Unit ={

    new Thread(new Runnable {
      def run= {
        for (i <- 1 to 15){
          println(i)
          Thread.sleep(100)

        }
      }
    }).start()
  for(c <- 'A' to 'Z')
    println(c)
    Thread.sleep(100)

  }
}