import scala.collection.mutable.HashMap

val hashmap1:HashMap[String,String] =HashMap(("PD","plain document"),("SD","Strwaberry document"))


println(s"element....${hashmap1("PD")}")

val emptyMap: HashMap[String,String] =HashMap.empty[String,String]


val x = HashMap(1 -> "b", 2 -> "a", 3 -> "c",3 -> "c").withDefaultValue("-")



x.put(4 ,"d")

x.foreach
{
  case (key, value) => println (key + " -> " + value)
    x.contains(key)
}



val str="hllo"

str.hashCode

//or
str.##

3.0.hashCode()

3.0.##

val m=13

def hash[K](key:K)={

val h=key.## % m
  if(h <0) h+m else h

}

hash("Hello")

hash(1000)

import scala.collection.mutable.Stack

val mystack =Stack[Int]()


mystack.push(1)
mystack.push(2)
mystack.push(3)
mystack.push(4)

println(s"stack $mystack")

println(s"popped ...${mystack.pop}")
println(s"popped ...${mystack.pop}")

mystack.top


24%10
2%10