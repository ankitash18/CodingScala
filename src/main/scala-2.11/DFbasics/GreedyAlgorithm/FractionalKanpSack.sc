/*

First, we have to find the value of the item per kg. To find this we have to calculate the value of “Vi/Wi“.
Now compare the value of each item per kg.
The item whose value is highest goes first in the bag and compare with the maximum weight bag can take. if the bag is full then it stops here.
If not then, second highest goes in the bag and compare with the maximum weight bag can take.
The same process goes on and on until the bag is full.
 */

def getmaxindex(weight:Array[Int],values:Array[Int]):Int ={

 var max_i =0
  var max:Double =0

  for(i <- 0  to weight.length-1){

    if(weight(i) != 0 && values(i)/weight(i) > max){
      max = values(i)/weight(i)
      max_i =0

    }
  }
  max_i
}

def getoptimalvalue(capacity:Int,weight:Array[Int],values:Array[Int]):Double ={

  var value:Double =0.0

  var capacity_1 = capacity

  for( i <- 0 to weight.length-1){

      if(capacity_1 == 0) {
        return value
      }
    val index =getmaxindex(weight,values)
    var a = Math.min(capacity_1,weight(index))
    value += a*(values(index)/weight(index))
    weight(index) -= a
     capacity_1 -= a

  }
   return value
}


val weight=Array(20,50,30)

val values =Array(60,100,120)

getoptimalvalue(50,weight,values)