// find number of swaps
/*
def bubblesort3(numbers:Array[Int]):Unit={

  var swaps =0

  for(k <- 1 until numbers.length ;j <- 0 until numbers.length -k if numbers(j) > numbers(j+1)) {
    val x=numbers(j)
    numbers(j) =numbers(j+1)
    numbers(j+1) = x
    swaps += 1
   // println(s"number of swaps $swaps")
  }

  println(s"Array is sorted in $swaps swaps.")
  println("First Element: "+numbers(0))
  println("Last Element: "+numbers(numbers.length-1))
}

val array4=Array(3,6,1,5,2,0,8)
val array1=Array(1,2,3)
bubblesort3(array1)

array4
*/

//find the maximum toys
/*
def maximumtoys(prices: Array[Int], k: Int): Int = {

  for(i <- 1 until arr.length){

    val tmp =arr(i)
    var j = i-1
    while(j > -1 && arr(j) > tmp){
      arr(j+1) =arr(j)
      j -=1
    }
    arr(j+1) =tmp

  }

  var count= 0
  var sum=0
  for(i <- 0 to prices.length-1){
    println(s"here ${prices(i)}")
    println(s"sum $sum")
    println(s"count $count")
      if(sum <=k){
        println(s"insdie if $k")
        sum=sum+prices(i)
        count +=1
      }

  }
//  count
println(count-1)
  count-1

}

//val prices=Array(1,2,3,4)
val prices =Array(1,12,5,111,200,1000,10)
//val k =7
val k=50

maximumtoys(prices,k)

*/

//fraudulent activity notification

def get_median(counting_sort_list:Array[Int],trailing_days:Int,median_position:Int):Int ={

 var counter =0
  var left =0
  while(counter < median_position){
    counter += counting_sort_list(left)
    left +=1
  }
  var right =left
  left -=1

  if(counter >median_position or trailing_days %2 !=0)
    left
  else
    while(counting_sort_list(right)==0)
    right +=1
  (left+right)/2

}

def activitynotification(expenditure:Array[Int],trailing_days:Int) {

  //initialise counting sort array
  counting_sort_list = Array(0)(201)
  var end = trailing_days


  // perform counting sort
  for (i <- 0 to end){
    counting_sort_list(expenditure(i)) +=1
    var current =0
    var total_notification =0

    //determine odd or even median position
    if (trailing_days%2 ==0)
      median_position = trailing_days/2
       else
      median_position = (trailing_days/2) +1

    total_expenditure_length =length(expenditure)

    //start and move along expenditure list
    while(end < total_expenditure_length){
     var  median=get_median(counting_sort_list,trailing_days,median_position)
      if(expenditure(end) >= median*2) {
        total_notification += 1
        //modify the queue,first in firsit out
        counting_sort_list(expenditure(current)) -= 1
        counting_sort_list(expenditure(end)) += 1
        current += 1
        end += 1
      }
    }


  }

  total_notification
}