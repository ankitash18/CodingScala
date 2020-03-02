package DFbasics.Trie

import scala.collection.mutable
import scala.collection.mutable.HashMap
import DFbasics.Trie.TrieNode

/**
  * Created by AShrivastava on 1/4/2020.
  */
class Trie {


 var root = new TrieNode()


  //insert word into trie
  def insert(word:String): Unit ={

        var current = root
    //println(s"current is now $current")
        for(i <-0 to word.length-1)
        {
         // println(s"i is  is $i")
        val ch = word.charAt(i)
          //println(s"ch is  is $ch")
        var node:TrieNode = current.childern.getOrElse(ch,null)
          //println(s"node  is  is $node")
          if (node == null) {
              node = new TrieNode()
              current.childern.put(ch, node)
              }
             current = node
          }
       current.endOfWord = true
       System.out.println("Successfully inserted " + word + " in Trie !")

  }

  //search for a word in trie
   def searchword(word: String): Boolean = {

    var currentNode = root
    for (i <- 0 to word.length - 1) {

      val ch = word.charAt(i)
      var node: TrieNode = currentNode.childern.getOrElse(ch,null)

      if(node == null){ //case 1- if node doesnt exist for given char then return false

        println("Word: " + word + " does not exists in Trie !")
        return false
      }
      currentNode = node

    }
    if(currentNode.endOfWord ==true) {
      println("Word: " + word + " exists in Trie !") //CASE#2 -- Word exists in Trie
    }
    else {
      //CASE#3 -- Current word is a prefix of another word. But this word does not exists
      println("word: $word  doesnt exist in trie,but this is prefix of another word in trie")
    }

    return  currentNode.endOfWord

  }

  //delete word from trie
  def delete(word:String): Unit ={
    if(searchword(word) ==true){
      delete(root,word,0)
    }
  }

  private def delete(parentnode:TrieNode,word:String,index:Int): Boolean ={

    // CASE#1 -- Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
    // CASE#2 -- We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
    // CASE#3 -- Some other word is a Prefix of this word (BCDE, BC)
    // CASE#4 -- No one is dependent on this Word (BCDE, BCDE)


    val ch=word.charAt(index)
    var currentNode:TrieNode = parentnode.childern.getOrElse(ch,null)

    var canthisnodebedeleted:Boolean =true

    if(currentNode.childern.size > 1){
      //case1
      println("enterning case1")
      delete(currentNode,word,index+1)
      return false
    }

    if(index == word.length-1){
      //case2
      println("enterning case2")
       if(currentNode.childern.size >=1) {
         currentNode.endOfWord = false //updating endOfWord will signify that this word is not there in Trie
         return  false
       } else {
         println("Character " + ch + " has no dependency, hence deleting it from last")
         parentnode.childern.remove(ch)
         return  true
         // If this word is not a prefix of some other word, and since this is last
         // character, we should
         // return true, indicating we are ok to delete this nod
       }
       }

     if(currentNode.endOfWord ==true){
       println("enterning case3")
       delete(currentNode,word,index+1)
       return  false
    }

    println("Entering Case#4")
    canthisnodebedeleted = delete(currentNode,word,index+1) //case4

    if(canthisnodebedeleted == true) {
      println("Character " + ch + " has no dependency, hence deleting it")
      parentnode.childern.remove(ch)
      return true
    }
    else
      return false

  }

}
