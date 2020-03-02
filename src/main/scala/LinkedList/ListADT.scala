package LinkedList

/**
  * Created by AShrivastava on 12/23/2019.
  */
trait ListADTX [A] {

  def apply(index:Int):A
  def update(index:Int,data:A):Unit
  def insert(index:Int,data:A):Unit
  def remove(index:Int):A

}
