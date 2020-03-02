package StackQueue

import scala.reflect.ClassTag

/**
  * Created by AShrivastava on 12/25/2019.
  */
class ArrayStack[A:ClassTag]  extends Stack[A]{


  private var data=new Array[A](10)

  private var top = 0

  def push(a:A):Unit ={


     if( top >= data.length){
       val tmp =new Array[A](data.length*2)
       Array.copy(data,0,tmp,0,data.length)
       data =tmp
     }
    println(s"top  is $top ")
    println(s"a  is $a ")
    data(top) = a
    println(s"after addition  is ${data(top)} ")
     top +=1


    println(s"after additiontop is $top ")

  }

  def pop():A ={

    //println(s"top  is $top ")
    //println(s"push data  is ${data(top)} ")
     top -=1
    println(s"after push pop  is ${data(top)} ")
    println(s"top  is $top ")
    data(top)


  }

  def peek:A = {
    println(s"peek is   is ${data(top-1)} ")
    data(top-1)

  }

  def isEmpty:Boolean ={

   // println("stack is empty")
    if (top ==0) true
    else false
  }


}
