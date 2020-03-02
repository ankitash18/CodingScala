//1sr method,direct use method
//using iterative impletmentation

val binary=183.toBinaryString

def decimaltoBinary(n:Int):String ={

  var x=n
  var binarystr=""

  while(x >0)
    {

      binarystr += (x%2)
      x/=2

    }

  binarystr.reverse
}


decimaltoBinary(183)


//using stack implmentation


def bnrystack(n:Int):String ={

  var x=n

  var stack = List[Int]()

  while(x >0){

    stack =(x%2) +: stack
    x/=2
  }
  stack.mkString

}

bnrystack(183)


//using function progamrming - we need genrator and transaformaion


val rands =Iterator.continually(Math.random())

rands.take(5).toList

val plusOne =Iterator.iterate(6)(n => n+1)

//plusOne.take(5).toList

plusOne.take(5).map(n => n*2).toList



val divideby2 =Iterator.iterate(183)(n => n/2)

//divideby2.take(10).toList

divideby2.takeWhile(n => n >0).toList


//method 2- uing functinal programming


def dectobny(n:Int):String = {

  val divideby2 = Iterator.iterate(n)(x => x / 2)

  val binaryList = divideby2.takeWhile(x => x > 0).map(x => x % 2)

  binaryList.mkString.reverse

}

dectobny(183)









