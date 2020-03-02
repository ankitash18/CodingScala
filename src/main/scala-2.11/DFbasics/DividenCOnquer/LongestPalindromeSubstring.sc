// strng should be consecutive order

/*

subsequcne is a sequcne that can be derived from another string by deleting /ignoring some or no elements wihtouth chnaging the order of
existing string.
 a substring  is a contiguous sequence  of character within a string
 */


def findLPSLength(string: String):Int = {
  return lps_aux(string, 0, string.length - 1)
  // end of method}

}
   def lps_aux(string: String, startIndex: Int, endIndex: Int): Int =
  {
    if (startIndex > endIndex) { //BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
      return 0
    }
    if (startIndex == endIndex) { //BASE CASE - If both the index are at same position then its a palidrome as its 1 character.
      return 1
    }
    var c1 = 0
    if (string.charAt(startIndex) == string.charAt(endIndex)) { //CASE#1 - If index pointed characters matches then we
      val remainingLength = endIndex - startIndex - 1 //add 2 to the existing known palindrome length only if
      //remaining string is a palindrome too
      if (remainingLength == lps_aux(string, startIndex + 1, endIndex - 1)) c1 = remainingLength + 2
    }
    val c2 = lps_aux(string, startIndex + 1, endIndex)
    //CASE#2 - Skip one element from beginning
    val c3 = lps_aux(string, startIndex, endIndex - 1) //CASE#3 - Skip one element from end
    Math.max(c1, Math.max(c2, c3)) //Take the max sized palindrome

  }

findLPSLength("ABCCBUA")