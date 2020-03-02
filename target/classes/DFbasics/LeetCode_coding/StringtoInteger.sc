/*
Implement atoi which converts a string to an integer.
If no valid conversion could be performed, a zero value is returned.
Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 */

//java solutoon

/*
public int myAtoi(String str) {

		int i = 0, flag = 0;
		StringBuilder st = new StringBuilder();

		// Clear white space characters
		while (i < str.length() && str.charAt(i) == ' ') {i++;}

		// Discover negative/positive sign
		if (i < str.length() && str.charAt(i) == '-') {
			st.append('-');
			i++;
		} else if (i < str.length() && str.charAt(i) == '+') {
			i++;
		}

		// Take numerals
		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			st.append(str.charAt(i));
			i++;
			flag = 1;
		}
		// If flag is 0, then there must be no numbers
		if (flag == 0) return 0;

		// Detect if number is bigger than 32 bit
		try {
			return Integer.parseInt(st.toString());
		} catch (NumberFormatException e) {
			// Return MIN or MAX based on sign
			return (st.toString().charAt(0) == '-')? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
	}
}
 */

// Link to question: https://leetcode.com/problems/string-to-integer-atoi/
def myAtoi(str: String): Int = {
  if(str == null || str.isEmpty || str.length == 0)
    return 0

  // To store the results
  var result = 0

  // Find index till first non white-space character
  var isSequenceStarted = false
  var index = 0
  while(isSequenceStarted == false && index < str.length){
    if(!str(index).equals(' '))
      isSequenceStarted = true
    else{
      index += 1
    }
  }
  println(s"Sequence starts from index: ${index}")

  if(isSequenceStarted){
    // Check if negative/positive sign is specified
    var multiplier = 1

    if(str(index).equals('-') || str(index).equals('+')){
      if(str(index).equals('-')){
        multiplier = -1
        index += 1
      }
      else if(str(index).equals('+')){
        multiplier = 1
        index += 1
      }
    }

    import scala.util.control.Breaks._

    var parsesdNumber = ""
    breakable {
      for(i <- index to str.length - 1){
        if(str(i).equals(' ') || !str(i).isDigit){
          break
        }
        if(str(i).isDigit)
          parsesdNumber += str(i)

      } // for loop ends here
    } // Breakable ends here

    if(parsesdNumber == null || parsesdNumber.isEmpty){
      result = 0
    }
    else{
      var res : Long =(parsesdNumber.toLong) * multiplier
      result = if(res <= Int.MaxValue && res >= Int.MinValue)
        res.toInt
          else{
            if(multiplier == -1){
              Int.MinValue
            }
            else
              Int.MaxValue
          } // result assignment ends here
    }
  } // Outernost if ends here
  result
}

def myAtoi1(str: String): Int = {
  val findValidStr = "^\\s*[-+]?[0-9]+.*".r

  val findNumbers = "^\\s*[-+]?[0-9]+".r
  var result: Long = 0
  str match {
    case findValidStr() =>{
      val intStr = findNumbers.findAllIn(str).mkString
      var flag = 1
      for(i <- 0 until intStr.length){
        val item = intStr.charAt(i)
        if(item == '-' || item == '+' || item == ' '){
          if(item == '-') flag = -1
        } else {
          result = result * 10 + item.asDigit
          if (result*flag > Int.MaxValue ) return Int.MaxValue
          else if (result*flag < Int.MinValue) return Int.MinValue
        }
      }
      result *= flag
      result.toInt
    }
    case _ => 0
  }
}
