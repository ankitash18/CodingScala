def factorial(n: Int): Int =
  if (n <= 0) 1
  else n * factorial(n-1)

println(factorial(5))


/* def fibonacci(n: Int): Int =
  if (n <= 2) 1
  else fibonacci(n-1) + fibonacci(n-2)
*/
println(fibonacci(3))


def isPrime(n: Int): Boolean = {
  def isPrimeUntil(t: Int): Boolean =
    if (t <= 1) true
    else n % t != 0 && isPrimeUntil(t-1)

  isPrimeUntil(n / 2)
}
println(isPrime(37))
println(isPrime(2003))
println(isPrime(37 * 17))



