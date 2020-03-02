import scala.collection.mutable
import scala.collection.mutable.{HashMap, ListBuffer}
///The moment you hear of FizzBuzz you think whether the number is divisible by 3, 5 or both.

//using string concatenation''

/*
Condition 1: 15 % 3 == 0 , num_ans_str = "Fizz"
Condition 2: 15 % 5 == 0 , num_ans_str += "Buzz"
=> num_ans_str = "FizzBuzz"
 */

def fizzbuzz(n:Int):List[String] = {


  val ans = new ListBuffer[String]()

  for(i <- 1 to n){

    val divisibleBy3:Boolean = (i %3 == 0)

    val divisibleBy5 :Boolean = (i%5 == 0)

    var numstr = ""

    if(divisibleBy3){
      numstr += "Fizz"
    }
    if(divisibleBy5){
      numstr += "Buzz"
    }

    if(numstr.equals("")){
      numstr += i.toString
    }

  ans.append(numstr)

  }

  ans.toList

}

fizzbuzz(4)

/*
This approach is an optimization over approach 2. When the number of mappings are limited, approach 2 looks good. But what if you face a tricky interviewer and he decides to add too many mappings?

Having a condition for every mapping is not feasible or may be we can say the code might get ugly and tough to maintain.

What if tomorrow we have to change a mapping or may be delete a mapping? Are we going to change the code every time we have a modification in the mappings?

We don't have to. We can put all these mappings in a Hash Table.
 */

def fizzbuzz1(n:Int):List[String]= {

  val ans = new ListBuffer[String]()

  // Hash map to store all fizzbuzz mappings.

  val fizzbuzzdict = HashMap[Int, String](3 -> "Fizz", 5 -> "Buzz")

  for (num <- 1 to n) {

    var numstr = ""

    for (key <- fizzbuzzdict.keySet) {

      // If the num is divisible by key,
      // then add the corresponding string mapping to current numAnsStr

      if (num % key == 0) {
        numstr += fizzbuzzdict(key)
      }
    }
      if (numstr.equals("")) {
        numstr += num.toString
      }

    ans.append(numstr)
  }
  ans.toList
}

fizzbuzz1(4)