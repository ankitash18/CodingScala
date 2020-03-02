class HelloThread extends Thread{

  override def run(): Unit ={

    println("hello")
    println("world")
  }

}

val t=new HelloThread()
val s=new HelloThread()

t.start()
s.start()
t.join()
s.start()
