//print stAIRCAse of #
def staircase(n:Int): Unit ={


  for(i <- 1 to n){
    for(j <- 1 to n-i){
       print(" ")
    }
    for(k <- 1 to i){
      print("#")
    }
   println()
  }
}

staircase(6)

//using one loop

def staircase1(n:Int): Unit ={

   var str ="#"

  for(i <- 0 to n-1){
      printf("%" + n +"s\n",str)
      str += "#"
    }

}

staircase1(6)