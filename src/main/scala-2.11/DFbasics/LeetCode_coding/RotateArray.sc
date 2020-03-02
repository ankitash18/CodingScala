val len = matrix.length - 1
for(  i <- 0 until len) {
  for (j <- i until len - i) {
    val top = matrix(i)(j)
    val rig = matrix(j)(len - i)
    val bot = matrix(len - i)(len - j)
    val lef = matrix(len - j)(i)
    matrix(i)(j) = lef
    matrix(j)(len - i) = top
    matrix(len - i)(len - j) = rig
    matrix(len - j)(i) = bot

  }
}