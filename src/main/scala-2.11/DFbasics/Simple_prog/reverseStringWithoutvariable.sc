
  def SwapWithoutTemp(s1:String,s2:String): Unit = {
    var a = s1
    var b = s2
    System.out.println("Before swap: " + a + " " + b)
    a = a + b
    b = a.substring(0, a.length - b.length)
    a = a.substring(b.length)
    System.out.println("After : " + a + " " + b)
  }
  SwapWithoutTemp("love","you")