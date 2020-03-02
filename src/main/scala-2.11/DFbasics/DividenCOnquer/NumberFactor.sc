/*

given n-find number of ways  to epress N as sum  of 1,3,4

4- {4},(1,3},{3,1},{1,1,1,1}

 */

def waysToGetN(n: Int):Int = {
  if ((n == 0) || (n == 1) || (n == 2)) { // { }, {1}, {1,1}
    return 1 //
  }
  if (n == 3) return 2 // {1,1,1}, {3}
  val subtract1 = waysToGetN(n - 1)
  // if we subtract 1, we will be left with 'n-1'
  val subtract3 = waysToGetN(n - 3)
  // if we subtract 3, we will be left with 'n-3'
  val subtract4 = waysToGetN(n - 4) // if we subtract 4, we will be left with 'n-4'
  subtract1 + subtract3 + subtract4
}

waysToGetN(4)
waysToGetN(5)