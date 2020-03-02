import scala.annotation.tailrec

@tailrec
def merge(l1:List[Int],l2:List[Int],lst:List[Int]):List[Int]=



  (l1,l2) match {

    case (Nil, _) => lst.reverse ::: l2
    case (_, Nil) => lst.reverse ::: l1
    case (h1 :: t1, h2 :: t2) =>
      if (h1 < h2) {

       // println(s"h1 $h1")
       // println(s"h2 $h2")
        merge(t1, l2, h1 :: lst)
      }

  else {
   println (s"here $l2")
  merge (l1, t2, h2 :: lst)
  }

  }


//o(n log n)

def mergesort(lst:List[Int]):List[Int] =lst match {

case Nil => lst
case h::Nil => lst
case _ =>

    val(l1,l2) = lst.splitAt(lst.length/2)
 println(s"l1 $l1")
  println(s"l2 $l2")
     merge(mergesort(l1),mergesort(l2),Nil)

}

//val lst =List(3,1,4,2,6,5)

val lst=List(2,1,3,1,2)
mergesort(lst)
//lst