import org.apache.commons.lang.StringUtils

/*
The objective here is to print multiplication tables uptil the number provided
 */

// just print it out in rows and columns, no formatting
def generate1(n: Int): Unit = {
  for (i <- 1 to n) {
    for (j <- 1 to n) {
      print("  " + (i * j))
    }
    println
  }
}

generate1(12)

// use StringUtils.lpad for formatting
def generate5(n: Int): Unit = {
  val maxwidth = String.valueOf(n * n).length
  for (i <- 1 until n) {
    for (j <- 1 until n) {
      print(StringUtils.leftPad(String.valueOf(i, j), maxwidth))
    }
    println
  }
}

generate5(12)