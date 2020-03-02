//val a =Array(2,1,5,3,4)
val a =Array(2,5,1,3,4)

val n=a.length
var cnt=0
for(i <- a.length-1 to 0 by -1 )
{
  if(a(i) != i+1){

    if(a(i-1)!=i+1 && a(i-2)!=i+1){


      println("too chaotic")
     system.continue
    }

    else if((i-1)>=0 && a(i-1) ==i+1){
      println("here")

      cnt+= 1
      val temp =a(i-1)
      a(i-1)=a(i)
      a(i)=temp
     // swap(a(i),a(i-1))
    }
    else if((i-2)>=0 && a(i-2)==i+1){
      cnt+=2
      a(i-2)=a(i-1)
      a(i-1)=a(i)
      a(i)=i+1

    }
  }


}
println("count.."+cnt)