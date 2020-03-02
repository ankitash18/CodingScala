/*

given array 2,4,10,10,10,18,20
find the first occurnceo fof 10 using binary search
 */

/*


binarysearch(a,n,x)
low -> 0
high -> n-1
result -> -1
while(low < = high)
mid = low +(low+high)/2
if( x == a(mid))
result = mid
high =mid-1
else if x < a(mid)
high = mid-1
else
low = mid+1
}

return result

 */