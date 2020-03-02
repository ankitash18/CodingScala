import scala.collection.mutable.ListBuffer



  def whichReels(p: Int, length: Array[Int]): List[Int] = {

    var reels = ListBuffer[Int]()

    var x = p
    while (x > 0) {

      var i = 0
      while (length(i) > x) i += 1
      reels += length(i)

      x -= length(i)

    }
    reels.toList

  }



val length =Array(10,5,2,1)

whichReels(29,length)


whichReels(16,length)


def whichreelsrec(p:Int):List[Int]={

  val length1 =Array(10,5,2,1)

  if(p==0) Nil
  else {

    var i=0
    while(length1(i) > p) i+=1
    length1(i) :: whichreelsrec(p - length1(i))

  }



}

//val length1 =Array(10,5,2,1)

whichreelsrec(29)
whichreelsrec(16)

//using case classes


val length2 =Array(10,5,2,1)

val sample =29

length2.map(len => sample/len)


case class choice(p:Int,reels:List[Int])



def whihcreelsfunc(p:Int):List[Int] ={
val finalchoice = length2.foldLeft(choice(p,List())) {

  (ch, len) =>

    val multiple = ch.p / len
    val reelstobuy = List.fill(multiple)(len)

    choice(ch.p - multiple * len, ch.reels ::: reelstobuy)


}
  finalchoice.reels
}

whihcreelsfunc(16)