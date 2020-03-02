/*

The first step is identifying that this problem can be solved with search. Given that it's under the search category let's jump straight to the assumption that a search approach will be the best.

When we're performing a search we need to start by defining some bounds (we need to search between two bounds otherwise how do we know where to start/stop)

How do we define our bounds then? Well let's start with the upper bound.

How many days would it take if ALL machines were equally as slow as the slowest machine?

If the slowest machine takes 5 days, we have 3 machines in total, and our goal is 30 then the worst case scenario is tha ALL machines take 5 days.

Given we have 3 machines that means that after 5 days we'll have 3 items produced. That means the worst case is goal / machines * slowestMachine = 50 days.

We can do the same thing to find the lower bound. Let's assume that all 3 machines are as fast as the fastest machine. Our lower bound is then goal / machines * fastestMachine = 10 days.

Now that we have our lower and upper bounds (10 - 50) we can finally start to search.

With binary search we always start at the middle of our bounds. The middle of our bounds is 35 ((lowerBound + upperBound) / 2) so let's start there.

Next we'll try to calculate how many items would be produced after this many days.

For each machine, how many items does it produce after 35 days? For that we use days / machine. Sum each of these values for each machineto get the total number of items produced by all machines after 35 days.

Now we check if we've met our goal or not. If we produce more than our goal, then the half way point that we chose is too high. If we produced less then the half way point was too low.

All we have to do now is repeat the steps but adjust our upper and lower bounds to be (lowerBound - middlePoint) or (middlePoint - upperBound) depending what side of the line we fell.
 */

val machines:Array[Long]=Array(2,3,2)
minTime(machines,10)

def minTime(machines: Array[Long], goal: Long) :Long= {
  machines.sorted
  val max = machines.max

//  println(s"max is $max")
  var minDays:Long = 0
 // println(s"minDays is $minDays")
  var maxDays:Long = max * goal
  //println(s"maxDays is $maxDays")
  var result:Long = -1
 // println(s"result is $result")
  while ( {
    minDays < maxDays
  }) {
   // println(s"maxDays is $maxDays")
   /// println(s"minDays is $minDays")
    val mid = (minDays + maxDays) / 2
   // println(s"mid is $mid")
    var unit :Long= 0
    for (machine <- machines) {
    //  println(s"machine is $machine")
      unit += mid / machine
      //println(s"unit is $unit")
    }
    if (unit < goal) {
      //println(s"unit is les then goal $unit")
      //println(s"minDays is ${ mid + 1}")
      minDays = mid + 1
    }
    else {
     // println(s"unit is greater then goal $unit")
      result = mid
      maxDays = mid
      println(s"result is $result")
      //println(s"maxDays is  $maxDays")
    }
  }
  result
}

