# CodilitySolution

##TapeEquilibrium question:
A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7 
P = 2, difference = |4 − 9| = 5 
P = 3, difference = |6 − 7| = 1 
P = 4, difference = |10 − 3| = 7 
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

## Analys as the following:
```
p=1: dif0=a0-(a1+a2+a3+a4)=-(a0+a1+a2+a3+a4)+2a0
p=2: dif1=(a0+a1)-(a2+a3+a4)=-(a0+a1+a2+a3+a4)+2(a0+a1)=dif0+2a1
p=3: dif2=(a0+a1+a2)-(a3+a4)=-(a0+a1+a2+a3+a4)+2(a0+a1+a2)=dif1+2a2
…
```
##therefore, I got first pseudocode as the following:
```
SET dif[0] to 2xarray[0]-sum
FOR p = 2 to array size - 2
	dif[p-1]=dif[p-2]+ array[p-1]x2
GET min value in dif
```
##I found I can improve like this:
```
SET temp to 2xarray[0]-sum
SET min to |temp|
FOR p = 1 to array size
     temp = temp + array[p]x2
     min=min(min, |temp|)
```
Time complexity: O(N)
Finally, convert the pseudocode to different language as the following:

1.[Java](https://github.com/desenG/CodilitySolution/blob/master/TapeEquilibrium/TapeEquilibrium.java)
1.[Objective C](https://github.com/desenG/CodilitySolution/blob/master/TapeEquilibrium/main.m)

