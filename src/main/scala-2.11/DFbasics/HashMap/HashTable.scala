package DFbasics.HashMap

/**
  * Created by AShrivastava on 2/2/2020.
  */
trait HashTable[K, V] {


    def insert(key: K, value: V): Unit

    def search(key: K): Any

    def delete(key: K): Any
  }



