def CalculateFibonacci(n: Int):Int ={
  if (n < 1) {
  println("Please enter a positive number")
  Integer.MIN_VALUE
}
else if (n == 1) 0
else if (n == 2) 1
else CalculateFibonacci(n - 1) + CalculateFibonacci(n - 2)

}

CalculateFibonacci(-2)