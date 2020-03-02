// inperative way
def bubblesort(numbers:Array[Int])={
 for(k <- 1 until numbers.length){
     for(j <- 0 until numbers.length-1){
       //or  for(k <- 1 until numbers.length ;j <- 0 until numbers.length-1)
       if(numbers(j) > numbers(j+1)){
         val x=numbers(j)
         numbers(j) =numbers(j+1)
         numbers(j+1) = x

       }

     }
 }

}

val array1=Array(3,6,1,5,2,0,8)
bubblesort(array1)

array1


val array2=Array(4,6,22,56,11,55,223,1,7,33,9,10,67,88)

bubblesort(array2)

array2


//using patttenr mathching ans guard

def bubblesort1(numbers:Array[Int])={

 for(k <- 1 until numbers.length ;j <- 0 until numbers.length-1 if numbers(j) > numbers(j+1)) {
   (numbers(j),numbers(j+1)) match {
     //case (x,y) if x > y =>
     case (x,y) =>
             numbers(j)   = y
             numbers(j+1) =x

      }

    }
}

val array3=Array(3,6,1,5,2,0,8)
bubblesort1(array3)

array3

//optimized way

def bubblesort3(numbers:Array[Int]):Unit={

  var swaps =0

  for(k <- 1 until numbers.length ;j <- 0 until numbers.length -k if numbers(j) > numbers(j+1)) {
    val x=numbers(j)
    numbers(j) =numbers(j+1)
    numbers(j+1) = x
   swaps += 1
    println(s"number of swaps $swaps")
  }

  println(s"number of swaps $swaps")
}

val array4=Array(3,6,1,5,2,0,8)
bubblesort3(array4)

array4