/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */


//1st soluton
val a =Array('h','e','l','l','o')


val s = "ankita"
s.substring(1,6)

a.reverse

a.toString


def reversestr(a:Array[Char]):Unit={

  var start = 0
  val end = a.length-1
  //var temp =None




  println(s"length is ...${a.length}")


  for( i <- 0 until a.length/2){


    val  temp = a(i)
    a(i) = a(end-i-1)
    a(end-i-1) = temp

  }

  for( i <- 0 to a.length-1){
    println(a(i))
  }


}

reversestr(a)


// recursively
def reverse3(s: String): String = {
  val len = s.length
  if (len == 1) {
    s
  } else {
    println(s.charAt(0))
    reverse3(s.substring(1, len)) + s.charAt(0)
  }
}

// recursively, with tail recursion
def reverse4(s: String): String = {
  val len = s.length
  if (len == 1) {
    s
  } else {
    s.substring(len-1, len) + reverse4(s.substring(0, len-1))
  }
}

// iterating backward through the string
def reverse2(s: String): String = {
  val buf = new StringBuilder
  val len = s.length
  println(len)
  for (i <- 0 until len) {
    buf.append(s.charAt(len - i - 1))
  }
  buf.toString
}

val s1 ="madA m'I madaM"

reverse3(s1)


def reverselist(n:List[Int]):List[Int]= n match {

  case (Nil) => Nil
  case  (h :: t) => reverselist(t) ::: List(h)


}


/*
print if string contains rverse of it
 */
val alist = List(1,2,3,4,5)
reverselist(alist)

val str = "My name is abcd yM si"

val strlist = str.split(" ").toList

for(i <- 0 to strlist.size-1) {
  println(strlist(i))
  val x = strlist(i).reverse
  if (strlist.contains(x)) {
    println(x)
  }
}

