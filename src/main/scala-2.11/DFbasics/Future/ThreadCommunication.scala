package DFbasics.Future
import java.lang._

import scala.collection.mutable
import scala.util.Random
/**
  * Created by AShrivastava on 1/10/2020.
  */
/*
object ThreadCommunication extends App{

  /*

  prodcuer/consumer probelm
  we r going to start  with ta small contaner whic wraps single valye and in parallel we will have two thread running one is prducer
  which has sole purspoe of setting vlaye inside container ,and cnsumer wholse sole purpose ia to extrct valye from contianer.
   */

  class simplecontainer{

    private var value:Int =0

    def isEmpty:Boolean =value ==0
    def set(newvalue:Int):Unit = value= newvalue
    def get:Int={
      val result =value
      value =0
      result
    }
  }


  def naiveprodcns :Unit={
    val container = new simplecontainer

    val consumer =  new Thread(() =>{
    println("consumer waiting...")
      while(container.isEmpty){
        println("consumer activelt waiting")
      }
      println("consumer..i have consumer "+ container.get)
    })

    val producer =  new Thread(() => {
     println("producer computing")
      Thread.sleep(500)
      val value =42
      println("i have produced valye" + value)
      container.set(value)

    })

    consumer.start()
    producer.start()

  }

  naiveprodcns()



  //wait n notify
  /*

  Synchronized-   enterning a syncronized expression on a object locks the objecr

  someobject.synchronized <--- locks the object's monitor
  monitor is data structure that is internally used by the jvm to keep trakc of which object is loced by which  thread
  once u have locked th object ,any othe thread thats tryign to read the same expression will block unrill u r done evaluatinn.

  once we weil relaese the lock any othe thread is free to evaluat the expression.
  only any ref can have synchrnized blocks
  genral pricncipal -
  make no assunpation abour  who gets the lock first
  keep lockign to minimum
  maintain thread safetly at all time in parallle application

  wait-realeas the monitor lock and wait objects montior
  notify - release t
   */


  def smartprodcons():Unit ={
    val container = new simplecontainer

    val consumer =  new Thread(() => {
      println("consumer waiting...")
      container.synchronized{
        container.wait()
      }
      println("consumer..i have consumer "+ container.get)
    })

    val producer =  new Thread(() => {
      println("producer computing")
      Thread.sleep(2000)
      val value =42
      container.synchronized {
        println("i have produced valye" + value)
        container.set(value)
        container.notify()
      }

    })

    consumer.start()
    producer.start()

  }

  /*

  producer prducing more then value and simultaneously consumer is receivnng
   */

  def prodconsbuffer  :Unit ={

    val buffer :mutable.Queue[Int]=new mutable.Queue[Int]
    val cpaapcity =3


    val consumer =new Thread(() => {

      val random= new Random()

      while(true){

        buffer.synchronized{
          if(buffer.isEmpty){
            println("consumer buffer empty..waiting")
            buffer.wait()
          }
         //there must be atleast one value in the buffer
          val x= buffer.dequeue()
          print("consumer consumer" +x)

          buffer.notify()

        }
        Thread.sleep(random.nextInt(500))
      }
    })

     val producer = new Thread(() => {

       val random = new Random()
       var i =0
       while(true){
         buffer.synchronized{
           if(buffer.size == cpaapcity){
             println("buffer is full..waiting")
             buffer.wait
           }
           println("prodcuer producing "+i)
           buffer.enqueue(1)
          buffer.notify()

           i +=1
         }
         Thread.sleep(random.nextInt(500))
       }
     })

    consumer.start()
    producer.start()
  }

//  prodconsbuffer()


  /*

  prod-cons - level
  multiple producer,multiple consumer acting on the same buffer
   */


  class consumer(id:Int,buffer:mutable.Queue[Int])  extends Thread{


    override  def run():Unit ={

      val random= new Random()

      while(true){

        buffer.synchronized{

          /*

          prodcuer prodcues value,teo cons are waiting
          notifies one consumer,notifies on bufer
          notifies the onthe rocnsumer
           */
          while(buffer.isEmpty){
            println("consumer buffer empty..waiting")
            buffer.wait()
          }
          //there must be atleast one value in the buffer
          val x= buffer.dequeue()
          print("consumer consumer" +x)

          buffer.notify()

        }
        Thread.sleep(random.nextInt(500))
      }
    }

    }

  class producer(id:Int,buffer:mutable.Queue[Int],capacity:Int) extends Thread{
    override  def run():Unit ={

      val random = new Random()
      var i =0
      while(true){
        buffer.synchronized{
          while(buffer.size == cpaapcity){
            println("buffer is full..waiting")
            buffer.wait
          }
          println("prodcuer producing "+i)
          buffer.enqueue(1)
          buffer.notify()

          i +=1
        }
        Thread.sleep(random.nextInt(500))
      }


    }

  }

  def multiprodcons(consuer:Int,producer:Int):Unit={


    val buffer:mutable.Queue[Int] = new mutable.Queue[Int]

    val cpapacity =3
    (1 to consuer).foreach(i => new consumer(i,buffer).start())
    (1 to producer).foreach(i => new consumer(i,buffer,capacity).start())

  }
  multiprodcons(3,3)
  }


*/