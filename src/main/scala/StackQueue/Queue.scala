package StackQueue

import org.apache.spark.sql.catalyst.parser.SqlBaseParser.FileFormatContext

/**
  * Created by AShrivastava on 12/25/2019.
  */
trait Queue[A] {

  //FIFO

  def enqueue(a:A):Unit

  def dequeue():A

  def peek: A

  def isEmpty:Boolean

}
