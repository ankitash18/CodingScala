/*

given  a string s1 and s2.need to convert s2 into s1 by deleting,inserting replacing caracters.
write a function to calcualte the count of minimum number of edi operation

s1=catch
s2= carch
output =1


 */


def findMinOperations(s1: String, s2: String) :Int = {
  return findMinOperationsAux(s1, s2, 0, 0)
  //end of method}
}

   def findMinOperationsAux(s1: String, s2: String, i1: Int, i2: Int): Int =
  {
    if (i1 == s1.length) { // if we have reached the end of s1, then insert all the remaining characters of s2
      return s2.length - i2
    }
    if (i2 == s2.length) { // if we have reached the end of s2, then delete all the remaining characters of s1
      return s1.length - i1
    }
    if (s1.charAt(i1) == s2.charAt(i2)) { // If the strings have a matching character, recursively match for the remaining lengths.
      return findMinOperationsAux(s1, s2, i1 + 1, i2 + 1)
    }
    val c1 = 1 + findMinOperationsAux(s1, s2, i1 + 1, i2)
    // perform deletion
    val c2 = 1 + findMinOperationsAux(s1, s2, i1, i2 + 1)
    // perform insertion
    val c3 = 1 + findMinOperationsAux(s1, s2, i1 + 1, i2 + 1) // perform replacement
    Math.min(c1, Math.min(c2, c3))
  }

findMinOperations("table", "tbres")