// inperative way
def selectionsort(numbers:Array[Int])= {
  for (j <- 0 to numbers.length - 1) {
    var minimumIndex = j
    for (i <- j + 1 to numbers.length - 1) {
      if (numbers(i) < numbers(minimumIndex))
        minimumIndex = i
      } //end of inner loop - finding the smallest element element of unsorted/right array
      if (minimumIndex != j) {
        //if j is not minimum index then swap
        val x = numbers(j)
        numbers(j) = numbers(minimumIndex)
        numbers(minimumIndex) = x
      }

    } //end of outer loop
  }

val array1=Array(3,6,1,5,2,0,8)
  selectionsort(array1)

array1