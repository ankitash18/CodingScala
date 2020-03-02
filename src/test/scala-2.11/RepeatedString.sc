val s = "aba"

val n = 10

// Complete the repeatedString function below.
def repeatedString(s: String, n: Long): Long = {

  val s1 = s.length
  var cnt = 0
  var cnt1 = 0
  var count = n / s1
  val rem = n % s1

  for (i <- 0 to s.length - 1) {
    if (s(i) == 'a') cnt += 1
  }

  val countbeeforeend = cnt * count

  for (i <- 0 to rem.toInt -1) {
    if (s(i) == 'a') cnt1 += 1
  }
  countbeeforeend + cnt1

}

repeatedString(s, n)