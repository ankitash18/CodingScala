def isPowerOfThree(n: Int): Boolean = {

  var num =n

  if(num < 1){
    return false
  }

  while (num%3 == 0 && num != 0){
    num = num/3
  }
  return num == 1
}