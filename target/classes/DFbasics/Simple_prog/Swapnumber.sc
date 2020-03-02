//swap number without third varibale

/*

method1 - addtin subtraction

1) x= x+y
2) y = x-y
3) x = x-y
 */

def swap(x:Int,y:Int)={

  var x1 = x
  var y1  = y

  x1= x1+y1
  println(s"x1 is..$x1")

  y1 = x1-y1

  println(s"y1 is..$y1")

  x1 = x1-y1

  println(s"x1 is..$x1")


  println(s"after swap x is $x1 and y is $y1")

}

swap(10,5)