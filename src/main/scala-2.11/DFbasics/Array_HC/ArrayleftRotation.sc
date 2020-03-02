/*

# Initial assignments:
# array = [1, 2, 3, 4]
# length_of_array = array.length = 4
# no_of_left_rotation = k = 2
 new_arr = Arra.new(length_of_array)
   new_arr: [nil, nil, nil, nil]

# NOTE:
# length_of_array.times do |i|
# is equivalent to
# for(i = 0; i < length_of_array; i++)

# Algorithm to calculate new index and update new array for each index (i):
# new_index = (i + no_of_left_rotation) % length_of_array
# new_arr[i] = array[new_index]


# LOOP1:
# i = 0
# new_index = (0 + 2) % 4 = 2
# new_arr[i = 0] = array[new_index = 2] = 3
# new_arr: [3, nil, nil, nil]

# LOOP2:
# i = 1
# new_index = (1 + 2) % 4 = 3
# new_arr[i = 1] = array[new_index = 3] = 4
# new_arr: [3, 4, nil, nil]

# LOOP3:
# i = 2
# new_index = (2 + 2) % 4 = 0
# new_arr[i = 2] = array[new_index = 0] = 1
# new_arr: [3, 4, 1, nil]

# LOOP4:
# i = 3
# new_index = (3 + 2) % 4 = 1
# new_arr[i = 3] = array[new_index = 1] = 2
# new_arr: [3, 4, 1, 2]

# After final loop our new roated array is [3, 4, 1, 2]
# You can return the output:
# new_arr.join(' ') => 3 4 1 2

(i + (lengthOfArray - no_of_left_rotation)) % lengthOfArray

Consider the above array, if n is 1 then, all elements of the array will be moved to its right by one position that is the first element of the array will take the second position, the second element will be moved to the third position and so on. The last element of the array will become the first element of the array.
*/

val arr =Array(1,2,3,4)

var n =2

var temp = 0

val last =arr.length

println(last)

val finalarr= new Array[Int](4)

for(i <- (arr.length-1) to 0 by -1)
  println(arr(i))

for(i <- 0 to arr.length-1) {

  val index = (i +(last - n)) % last

  println("index.." + index)

  finalarr(i) = arr(index)
}

def rotate(arr:Array[Int],k:Int)={

  //val arr1=new Array[Int](arr.length)

  //Rotate the given array by n times toward right
  for(i <- 0 to k-1){

    //Stores the last element of array
    val first = arr(0)
    var j=0

    //Shift element of array by one
    for(j <- 0 until (arr.length-1)){
      arr(j) =  arr(j+1)
    }
    //Last element of array will be added to the start of array.

    arr(arr.length-1) = first

  }

  println("after rotation")
  for( i <- 0 to arr.length-1){
    println(arr(i))
  }
}

val arr1 =Array(1,2,3,4,5)

var n1 =3
rotate(arr1,n1)