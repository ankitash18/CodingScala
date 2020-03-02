package DFbasics.Implicit

/**
  * Created by AShrivastava on 12/28/2019.
  */
object MyLibrary extends App{

  //2.isprime -using implicit classes


  implicit class RichInt(val value:Int) extends AnyVal{
    def isEven:Boolean =value%2 ==0
    def sqrt:Double=Math.sqrt(value)

    def times(function: () => Unit):Unit={
      def timesAUx(n:Int):Unit =
        if(n <=0)()
         else {
          function()
           timesAUx(n - 1)
        }
      timesAUx(value)
    }

    def *[T](list:List[T]):List[T]={
      def concatenate(n:Int):List[T]=
        if(n <=0) List()
        else concatenate(n-1) ++ list

      concatenate(value)
    }
  }

  println(new RichInt(2).sqrt)

  42.isEven //type -enrichment

  42.toString

  import scala.concurrent.duration._
  3.seconds //implicit method

  /*
  enrich the string class
  -asInt
  -encrypt
  john -> lnjp(encrytpe valye of strig john
  keep enrichinig Int class with two methods
  - times(funciton) 3.times(()->....)
  - *
  3* List(1,2) => List(1,2,1,2,1,2)

   */

  implicit  class RichString(string:String){


    def asInt:Int =Integer.valueOf(string) //java.lang.Interger -> Int

    def encrypt(cypherdistance:Int):String =string.map(c => (c+cypherdistance).asInstanceOf[Char])
  }

  println("3".asInt)

  println("john".encrypt(2))

  3.times(() => println("sclaa rocks"))

  println(4 *List(1,2))


  implicit  def stringtoInt(string:String):Int = Integer.valueOf(string)

  println("6" /2) //stringtoInt("6") /2

  //equivalent -implicit class RichAltDiv(value:Int)
  class RichAltInt(value:Int)
  implicit def enrich(value:Int):RichAltInt = new RichAltInt(value)

  //danger zone
  implicit  def InttoBoolean(i:Int):Boolean =i ==1

  /*
  if  (n) do somethin
  else do somehting else
   */

  val condtionvalue=if(1) "ok" else "wrong"


  println(condtionvalue)

  /*

  tipes - keep type enrichment to implicit classes and tpe classes
  avoid implicit def as much as possible
   */
}
