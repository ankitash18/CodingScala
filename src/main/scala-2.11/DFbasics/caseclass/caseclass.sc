case class accident(dlnumber1:String,dlnumber2:String)

case class driver(name:String,dlnumber:String,dob:String,history:List[accident])

def weck(d1:driver,d2:driver):(driver,driver,accident)={

  val Accident = accident(d1.dlnumber,d2.dlnumber)

  (d1.copy(history = Accident :: d1.history),
  d2.copy(history = Accident :: d2.history),
  Accident)

}

var me = driver("mark","12345","long ago",Nil)

var otherperson = driver("john","86574","01/01/1990",Nil)

val(newmw,newother,acc) = weck(me,otherperson)

println(newmw)

println(newother)

me = newmw

println(me.name)

otherperson = newother

println(s"vvv ${otherperson.dlnumber}")


println(me.history.length)

val l1 = List(1,2,3)

val l2 = List(4,5,6)

l1.zip(l2).map(t => t._1 * t._2)

(l1,l2).zipped.map(_*_)