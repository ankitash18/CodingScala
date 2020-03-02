package DFbasics.Trie

import scala.collection.mutable.HashMap

/**
  * Created by AShrivastava on 1/4/2020.
  */
class TrieNode {

  var endOfWord:Boolean =false
  var childern : HashMap[Character, TrieNode] = new HashMap[Character, TrieNode]


}
