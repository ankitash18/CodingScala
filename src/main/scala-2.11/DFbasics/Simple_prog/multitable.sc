def multiTable = {
  val table = for (i <- 1 to 10) yield {
    val row = for (j <- 1 to 10) yield {
      val prod = (i * j).toString
      String.format("%4s", Array(prod))

    }
    row.mkString + '\n'
  }
  table.mkString
}
println(multiTable)


val n =4

val half =
  if (n % 2 == 0)
    n / 2
  else
    throw new Exception("n must be even")

/*
hihger order function
 */
/*
object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles
  private def filesMatching(matcher: String => Boolean) =
    for (file <filesHere;
         if matcher(file.getName))
      yield file
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
  def filesContaining(query: String) =
    filesMatching(_.contains(query))
  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}

*/

/*

def containsZero(nums: List[Int]): Boolean = {
var exists = false
for (num <nums)
if (num == 0)
exists = true
exists
}

def containsZero(nums: List[Int]) = nums.exists(_ == 0)
 */