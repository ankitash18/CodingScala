val arr =Array(1,2,3,4,5)

var n =4

var temp = 0

  val last =arr.length

println(last)

val finalarr= new Array[Int](5)

for(i <- 0 to finalarr.length -1)
  println(finalarr(i))

for(i <- 0 to arr.length-1) {

  val index = (i +( n)) % last

  println("index.." + index)

    finalarr(i) = arr(index)


}

for(i <- 0 to finalarr.length -1)
  println(finalarr(i))

