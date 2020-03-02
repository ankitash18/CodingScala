/* val str ="Hi,there hello"



val pattern ="hello"
str.indexOf(pattern)

str.length - pattern.length


str.charAt(1)
str(1)

str.foreach(c => print(s"$c"))
*/
//Naive string Searhcing algorithm

def substringsearch(text:String,pattern:String):Int={
  var index = -1

  for(i <-0 to text.length-pattern.length if index == -1){
    var j =0

    while(j < pattern   && text(i+j)== pattern(j)) {
      println(s"j.. $j")
      j += 1
    }
    if(j == pattern.length)
    //  println(s"j inside.. $j")
      index =i

  }
  index

}

val str ="Hi,there hello"



val pattern ="hello"

substringsearch(str,pattern)

//functinal impemention

//use of find/option/get ot else function

val mylist=List(2,2,3,5,6,7)
val optnum = mylist.find(_== 5)

val n = optnum.getOrElse(-1)

mylist.indices.find(i => mylist(i) ==5).getOrElse(-1)



//str.indices.find(i => str(i) == "hello").getOrElse(-1)



def naivesubstring(text:String,pattern:String):Int ={

text.indices.find { i => i + pattern.length <= text.length &&
  pattern.indices.forall(j => text(j+i) ==pattern(j))
}.getOrElse(-1)

}

val str1 ="Hi,there hello"



val pattern1 ="hello"

naivesubstring(str1,pattern1)