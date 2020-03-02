import scala.util.matching.Regex

/*
   fold , foldLeft and foldRight all three takes 2 arguments:
   1. initial value
   2. function -> this function also takes two value. first one is accumulated and next one is any elements in list or array
    */

val list = List(5,8,2,6,8)

val listFold = list.fold(0)((a,i) => a + i)
val listFoldLeft = list.foldLeft(0)((a,i) => a + i)
val listFoldRight = list.foldRight(0)((a,i) => a + i)

println(listFold)
println(listFoldLeft)
println(listFoldLeft)

val string1 = "s,dd,hdl"

val strlinst = string1.split(",").toList

val list2 = List("s","dd","hdl")

val list2Fold = list2.fold("m")((a,i) => a + i)
println(list2Fold)

val list2Fold3 = strlinst.foldRight("")((a,i) => a + i)
println(list2Fold3)

val list2Fold1 = list2.fold("")((a,i) => a + i)
println(list2Fold1)


val pattern8 = new Regex("(S|s)cala")
val str = "Scala is scalable and cool"

println((pattern8 findAllIn(str)).mkString(","))
println(pattern8 replaceFirstIn(str,"Java"))
