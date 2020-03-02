package DFbasics.Trie

/**
  * Created by AShrivastava on 1/4/2020.
  */
object TestTrie extends  App{

  val trie = new Trie()

  //case1
  trie.insert("bcde")
  trie.insert("bckg")
  trie.delete("bcde")
  trie.searchword("bcde")

}
