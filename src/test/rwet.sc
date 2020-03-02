class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

val l1 = new ListNode(2)
l1.next=new ListNode(3)

println(l1.next )
var s = new Array[Int](10)

var a1 = l1
var a_cnt =0

while (a1.next != null){
  println(s"on element --> ${l1.x}")
  s(a_cnt) = l1.x
  a1=a1.next
  a_cnt = a_cnt + 1
}
s(1) = a1.x

println("+++++++++++++++")
for (i<- s) println(i)
