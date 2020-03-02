/*

needto create 2d array
 */

def lcs(s1:String,s2:String):Int={

  val m = s1.length
  val n = s2.length

  val L =  Array.ofDim[Int](m+1,n+1)

   for(i <- 1 to m){
     for( j <- 1 to n){

      // println(s"i...$i")
     //  println(s"j...$j")

       if(i == 0 || j == 0) {
         L(i)(j) = 0
       }
       else if(s1(i-1) == s2(j-1))
         {
          // println(s"..here when i is $i")
           L(i)(j) = L(i-1)(j-1) +1
         }
       else{
        // println(s"..here when i is $i")
         L(i)(j)=Math.max(L(i-1)(j),L(i)(j-1))
       }
     }
   }
  return L(m)(n)
}

lcs("elephant", "erepat")

/*
using single arraty - bottom up approach
 */
def lcs1(s1:String,s2:String):Int={

  val m = s1.length
  val n = s2.length


  val memo = new Array[Int](n+1)

  for(i <- 1 to m){
   // println(s" i is ....$i")
    var prev =0

    for( j <- 1 to n){
    //  println(s"j is ....$j")
      val temp = memo(j)
    //  println(s"temp is ....$temp")
      if((s1(i-1)).toUpper == (s2(j-1)).toUpper){
      //  println(s"inside")
        memo(j) = prev+1
       // println(s"memo(j) is ${memo(j)}")
      }else{
        memo(j) = Math.max(memo(j),memo(j-1))
       // println(s"memo(j) is ${memo(j)}")
      }
      prev = temp
    }
  }
  memo(n)
}
lcs1("daBcd", "ABC")