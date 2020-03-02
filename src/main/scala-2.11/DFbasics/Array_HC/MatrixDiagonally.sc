//m = no of rows
// n= no of columns


for(k <- to m-1){


  i =k
  j=0
  while(i >=0){
    print(M(i)(j))
     i -=1
    j +=1
  }
}

for(k <- 1 to n-1){

  i = m-1
  j =k
  while(j >= n-1){
    print(M(i)(j))
    i -= 1
    j +=1
  }
}