def countdown(n:Int): Unit ={
 if(n > 0)
   {
     println(n)
     countdown(n-1)
   }

}

countdown(5)

def countup(n:Int): Unit = {
  if (n > 0) {

    countup(n - 1)
    println(n)
  }
}
countup(5)