def reversearray(a:Array[Int]):Unit ={


  var start = 0
  var end = a.length-1

  var temp = Integer.MIN_VALUE

  while(start <= end){


    temp =a(start)
    a(start) = a(end)
    a(end) = temp

    start +=1
    end -=1
  }

  for( i<-0 to a.length-1){
    println(a(i))
  }
}


val arr =Array(1,3,5,6,7)
reversearray(arr)



