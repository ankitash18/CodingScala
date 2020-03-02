//find the inxed in string,if rmeoving any elemnt will make it palindorme.

/*

start from index 0 ,
anohter lloop from index last
compare if thy r equal
where it is not equal means it is loding it palindrome
 */

def palidromeindex(n:String):Int ={


  var palindrome = -1
  val len= n.length

  for(i<-0 until len/2){

    if(n(i) != n(len-1-i)){

      if((i+1) < len){

        val isstringvalidpalidrome = isvalidpalindrome(n.substring(i+1,len-i))
         if (isstringvalidpalidrome)
           palindrome = i
        else
           palindrome =  len-1-i
      }

    }
  }
  palindrome
}


def isvalidpalindrome(s:String):Boolean={


  val len=s.length

  for( i <-0 until len/2){

    if(s(i) != s(len-1-i)){
      return false
    }
  }
  return true
}

val a = "aabccccaa"
palidromeindex(a)