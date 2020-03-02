/*

sort all floer prices in asending order
start backwards from the most expensive flower,stop when there is no more flowers left
Calculate total
increment bought by 1 when everyone in the group has bought equal number of flowers
 */


def calulateminprice(flowers:Array[Int],k:Int):Int={

  //sort all flower prices in ascending order

  val cost= flowers.sorted

  var i = cost.length-1
  var bought =0
  var total =0

  //start backwards from the most expensive flower, stop when there is no more flowers left

  while(i >= 0)
    {
      //calcualte total
      for(j <- 0 until k if i >= 0 ){
        total += (1+bought)*cost(i)
        i -= 1
      }
      //increment bought by 1 when everyone in the group has bought equal number of flowers
      bought += 1
    }

 total
}

val flower =Array(1,3,5,7,9)
calulateminprice(flower,3)