package StackQueue

import scala.reflect.ClassTag

/**
  * Created by AShrivastava on 12/26/2019.
  */
class ArrayQueue[A:ClassTag] extends Queue[A]{

  private var data=new Array[A](10)

  private var front =0
  private var back =0

  def enqueue(a:A):Unit ={

    if((back+1) %data.length ==front){
      val tmp =new Array[A](data.length*2)
     for(i <- 0 until data.length-1){
       tmp(i)= data((front+i)%data.length)
       data =tmp
       front =0
       back =data.length-1
     }

    }
    data(back) =a
    back =(back+1) %data.length

  }

  def dequeue():A ={

    val ret=data(front)
    front +=1
    if(front >=data.length) front =0
    // or front =(front+1) %data.length
    ret

  }

  def peek: A =data(front)

  def isEmpty:Boolean = front==back

}
