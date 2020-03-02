/*
Given a 32-bit signed integer, reverse digits of an integer.
 */

val x:Int = 1234

//1st soltuion
def reverseint(x:Int)={


  val s = Math.abs(x).toString
  try {
    val reverse = s.reverse.toInt
    if (x > 0) reverse
    else -1 * reverse
  }
  catch {
    case e: Exception => 0
  }

}

reverseint(x)

//2nd solution using mod openrator

def reverseint1(x:Int):Int={

  var result :Long = 0
  var num = x
  while(num!= 0){
     result *= 10
     result +=  num%10
     num = num/10

  }

  println(result)

  if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
    return 0
else
    result.toInt
}

reverseint1(x)