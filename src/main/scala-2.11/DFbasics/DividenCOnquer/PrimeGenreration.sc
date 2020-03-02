val s2:Stream[Int] = 2 #:: Stream.from(3).filter(c => c % 2 ==0)


s2.take(5).toList

val s3:Stream[Int] = 2 #:: Stream.from(3).filter(c => c % 2 ==0 && c%3 ==0)


s3.take(5).toList


val s4:Stream[Int] = 2 #:: Stream.from(3)
     .filter{c =>
             val primes =List(2,3,5,7)
              !primes.exists(p => c%p ==0)
   }

s4.take(10).toList


val allPrimes:Stream[Int] =2 #:: Stream.from(3)
                       .filter{ c =>
                        val primestoSqrt=allPrimes.takeWhile(p => p <=math.sqrt(c))
                                         !primestoSqrt.exists(p => c%p ==0)

                       }



allPrimes.take(20).toList
