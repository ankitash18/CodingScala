import scala.io.Source

//the pbject which case class create is immutable
//copy creates a new instance of case class ,this way while cpying we cna modyf te valye

case class TempData(dayofMonth:Int,dayofYear:Int,month:Int,year:Int,tave:Double,tmax:Double,tmin:Double)


def parseTemps(line:String):TempData={


  val p=line.split(",")
  val dom=p(0).toInt
  val doy = p(1).toInt
  val month =p(2).toInt
  val year =p(4).toInt
  val ave =p(5).toDouble
  val max =p(6).toDouble
  val min =p(7).toDouble


  TempData(dom,doy,month,year,ave,max,min)



}

val source = Source.fromFile("sample.txt")

val lines =source.getLines()

lines.next
lines.next //sikkpin firstt tow lines

val tempdata = lines.filter(!_.contains(",.")).map(parseTemps).toArray
source.close()



//avg high  . low temp for entriee time period

println("Ave =" + tempdata.map(_.tave).sum/tempdata.length)

println("High =" + tempdata.map(_.tmax).sum/tempdata.length)


println("Low =" + tempdata.map(_.tmin).sum/tempdata.length)


//avg temp fpr each mlonth


for(month <- 1 to 12){

  val monthdata =tempdata.filter(_.month ==month)
  println("Ave =" + monthdata.map(_.tave).sum/monthdata.length)



}

println("high above 100=" + tempdata.count(_.tmax >=100))