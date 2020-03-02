package DFbasics.HashMap

import DFbasics.HashMap.HashTableImpl

/**
  * Created by AShrivastava on 11/23/2019.
  */
object MutableHashApi {

  def main(args: Array[String]): Unit = {


    val table: HashTable[Int, String] = new HashTableImpl[Int, String](13)

    table.insert(123, "sam")
    table.insert(124, "Joe")
    table.insert(125, "ruth")
    table.insert(126, "Luis")

    println(s"Ths should be sam", table.search(123))
    println(s"Ths should be Joe", table.search(124))
    println(s"Ths should be ruth", table.search(125))
    println(s"Ths should be Luis", table.search(126))
    println(s"Ths should be None", table.search(111))

    println(s"Ths should be Joe", table.delete(124))
    println(s"Ths should be None", table.delete(124))


  }
}
