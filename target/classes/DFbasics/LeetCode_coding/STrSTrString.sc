/*
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
without using indexOf
 */

val haystack = "hello"

val str :List[Char]=List('1','2','1','1')

split(str)


  //.map(x => s"${x.length}${x.head}").mkString

haystack.indexOf("o")

def strtstr(haystack:String,needle:String):Int ={


  val h = haystack.length
  val n = needle.length

  // Empty needle matches at first index
  if(n ==0){
    return 0
  }


  val max = h - n + 1
  var i =0
  while( i < max){


    // Skip if first character does not match
    while(i < max && haystack(i) != needle(0)){
      i +=1
    }

    // Once first character matches, match both words by character

    var count =0
    var j = 0
    while(j < n && i < max && haystack(i+j)== needle(j)){
      count +=1
      j +=1
    }
    // If all characters in needle match,
    // return the index
    if(count == n){
      return i
    }
  }
  return -1

}

val haystack1 = "hello"
val needle1 = "o"

strtstr(haystack1,needle1)


//scala recursive solutin
/*
 @annotation.tailrec
  def find(h: String,x:String, n: Int): Int =
    if (n > h.length - x.length) -1
    else if (h.substring(n,n+x.length) == x) n
         else find(h,x,n+1)

  def strStr(haystack: String, needle: String): Int =
    if(needle.isEmpty) 0
    else find(haystack,needle,0)

}
 */


//using substring
def strStr1(haystack: String, needle: String): Int =  {
 val m: Int = haystack.length
val n: Int = needle.length
if (n == 0)  {
 return 0
}
if (n > m)  {
return -(1)
}
for(i <- 0 until m-n+1){

if (haystack.substring(i, i + n) == needle)  {
    return i
}
}
return -(1)
}


val haystack2 = "hello"
val needle2 = "o"

strStr1(haystack2,needle2)