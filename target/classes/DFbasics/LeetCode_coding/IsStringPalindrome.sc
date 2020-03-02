val s= "A man, a plan, a canal: Panama"

//scala soltuon using filter
val filtered_S = s.filter(_.isLetterOrDigit)

println(s)

val s1 = filtered_S.map(x => x.toLower).reverse

val s2 = filtered_S.map(x => x.toLower)

if(s1 == s2)
 println("equal")
else
  println("Not equal")

s.replaceAll("[^A-Za-z0-9]", "").toLowerCase

//iterative method

def ispalindrome(s:String):Boolean= {

  val arr = s.toCharArray
  var i = 0
  var j = s.length - 1

  while (i <= j) {

    while (!isAlphanumeric(arr(i)) && i< j){
      i +=1
    }

      while(!isAlphanumeric(arr(j)) && j >= 0) {
        j -= 1
}
    if(i <= j && j >=0 && i < s.length-1){

      val thisForward = if (arr(i) >= 97) arr(i) - 32 else arr(i)
      val thisBackWard = if (arr(j) >= 97) arr(j) - 32 else arr(j)
      if(thisForward != thisBackWard){
        return false
      }
       else
         i += 1
         j -= 1
    }
  }
    return true

}

 def isAlphanumeric(c: Char) :Boolean= {
   (c <= 122 && c >= 97) || (c <= 90 && c >= 65) || (c >= 48 && c <= 57)
 }


val a  = "A man, a plan, a canal: Panama"

ispalindrome(a)

