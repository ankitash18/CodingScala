/*
LCS
given ywo string s1 and s2
find longest subsequcne whici s common in both strng

s1 ="elephant"
s2=erepat
IT IS ALSO called common child question
 */

def findLCSLength(s1: String, s2: String):Int = {
  return findLCSLengthAux(s1, s2, 0, 0)
  //end of method}
}

  def findLCSLengthAux(s1: String, s2: String, i1: Int, i2: Int): Int =
  {
    if (i1 == s1.length || i2 == s2.length) { //Base Case
      return 0
    }
    var c3 = 0
    if (s1.charAt(i1) == s2.charAt(i2)) { //If current character in both the string matches, then increase the index by 1 in both the strings.
      c3 = 1 + findLCSLengthAux(s1, s2, i1 + 1, i2 + 1)
    }
    val c1 = findLCSLengthAux(s1, s2, i1, i2 + 1)
    //Increase index of 2nd String
    val c2 = findLCSLengthAux(s1, s2, i1 + 1, i2) //Increase index of 1st String
    Math.max(c3, Math.max(c1, c2))
  }

//findLCSLength("elephant", "erepat")
//findLCSLength("SHINCHAN", "NOHARAAA")
findLCSLength("ABCDEF", "FBDAMN")
