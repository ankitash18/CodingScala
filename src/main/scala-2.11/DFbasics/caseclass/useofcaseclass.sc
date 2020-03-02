import scala.io.Source

//store a file data

case class Player(name:String,made:Int,attempted:Int,rebounds:Int,points:Int)


def makeplayer(line:String):Player ={

   val p=line.split("\t")
   val name =p(0) //first column in file
  val  shots = p(2).split("-")
  val made =shots(0).toInt

  val attempted=shots(1).toInt
  val rebounds =p(7).toInt
  val points=p(14).toInt

  Player(name,made,attempted,rebounds,points)


}

val source = Source.fromFile("C:\\Users\\AShrivastava\\Desktop\\IdeaProjects\\SparkSBT\\src\\main\\resources\\data\\sample")

val lines =source.getLines()

val players = lines.map(makeplayer).toArray
source.close()
players.foreach(println)

println(players.map(_.points).sum)