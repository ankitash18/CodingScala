//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array
//array manupulation

def arraymaniulation(n:Int,m:Int) {

  //var n:Long =0

  //var m:Long =0

  val arr =new Array[Int](n+1)
  //val finalarr= new Array[Int](5)


  for(i <-0 to n){
    arr(i)= 0
  }


  for(i <-0 to m.length){

    var p:Long=0
    var q:Long =0
    var r:Long=0
    arr(p)=arr(p)+r
    if(q+1 <=n){
      arr(q+1)=arr(q+1) -r
    }
  }

  var sum:Long =0
  var max:Long =0
  for(i <-1 to n){
    sum=sum+arr(i)
    if(sum > max)
      max =sum
  }
return sum
}

arraymaniulation(5,3)