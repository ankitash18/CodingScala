def getinvcnt(n:Array[Int]):Int={

  var inv_count =0
  for(i <- 0 to n.length-1){
    for(j <- i+1 to n.length-1){
      if(n(i) > n(j))
        inv_count+= 1
    }


  }
  println(inv_count)
  inv_count
}

val n =Array(3,-7,0)
getinvcnt(n)

n.sorted