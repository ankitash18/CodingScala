def palin(n:String):Boolean= {

  var i = 0
  var j = n.length - 1

  while (i < j) {
    if (n(i) != n(j)) {

      return false
    }
  else
  i += 1
  j -= 1
}

  return true


}


val n = "abba"
palin(n)