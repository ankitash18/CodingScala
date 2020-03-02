//rows and column are sorted

/*
n*n matrix
go to the last element in 1st row
i =0 j=n-1
while (i  < n && j >=0)
if s == m(i)(j)matched retur 1
else
if s < m(i)(j)
j --
elseif s > m(i)(j)
i++
 */\

var i =0
vae j =n-1
while( i < n && j >=0){

  if (s == m(i)(j))
    print("found")
  //return
  else if (s < m(i)(j))
    j -=1
  else
    i +=1
}