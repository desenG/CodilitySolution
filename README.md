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
FOR p = 2 to array size-2
     temp = temp + array[p-1]x2
     min=min(min, |temp|)
```
Time complexity: O(N)

Finally, convert the pseudocode to different language as the following:

1.[Java](https://github.com/desenG/CodilitySolution/blob/master/TapeEquilibrium/TapeEquilibrium.java)

2.[Objective C](https://github.com/desenG/CodilitySolution/blob/master/TapeEquilibrium/main.m)

3.[C #](https://github.com/desenG/CodilitySolution/blob/master/TapeEquilibrium/Program.cs)

#DivisibleSumPairs
##DivisibleSumPairs question:

You are given an array of  integers, , and a positive integer, . Find and print the number of pairs where  and  +  is evenly divisible by .

Input Format

The first line contains  space-separated integers,  and , respectively. 

The second line contains  space-separated integers describing the respective values of .

Constraints

2 <=n <=100
1 <=k <=100
1 <=ai<= 100

Output Format

Print the number of  pairs where  and  +  is evenly divisible by .

Sample Input

6 3

1 3 2 6 1 2

Sample Output

5
 
##analys:
```
(a0+a1) mod k=0? ++count
(a0+a2) mod k=0? ++count
…
(a1+a2) mod k=0? ++count
…
```
##pseudocode:
```
READ 2 numbers with space as separator from console 
if Constrain check ok
	1st as n, 2nd as k  
READ n numbers with space as separator
if Constrain check ok
	put numbers to array
FOR each element as a
	FOR each element after a as b
		if (a+b) mod k=0
			count++
	END LOOP
END LOOP
```		 
Complexity:
time complexity is O(N^2)

space complexity is O(1)
 
Finally, convert the pseudocode to different language as the following:

1.[Java](https://github.com/desenG/CodilitySolution/blob/master/DivisibleSumPairs/DivisibleSumPairs.java)

# Sherlock and Valid String
You know my powers, my dear Watson, and yet at the end of three months I was forced to confess that I had at last met an antagonist who was my intellectual equal.

A "valid" string is a string S  such that for all distinct characters in  S each such character occurs the same number of times in S.

For example, aabb is a valid string because the frequency of both characters a and b is 2, whereas aabbc is not a valid string because the frequency of characters a, b, and c is not the same.

Watson gives a string S to Sherlock and asks him to remove some characters from the string such that the new string is a "valid" string.

Sherlock wants to know from you if it's possible to be done with less than or equal to one removal.

##Input Format

The first and only line contains S, the string Watson gives to Sherlock.

##Constraints
1<=|S|<=10^5
2. String  S contains lowercase letters only (a-z).
Output Forma

Output YES if S string  can be converted to a "valid" string by removing less than or equal to one character. 
Else, output NO.

##Sample Input

aabbcd
Sample Output

NO

##Explanation

2 is the minimum number of removals required to make it a valid string. It can be done in following two ways:

Remove c and d to get aabb. 

Or remove a and b to get abcd.

##Analys:
```
aabbcd

a:2
b:2
c:1
d:1
e:0
…

a: array[‘a’-‘a’]++
a: array[‘a’-‘a’]++
..

[2,2,1,1,0,0,…]

2 foundsame=false founddif=false,repeatvalue=0
2: 2=2 foundsame=true repeatvalue=2
1: 1!=2 founddif=true
1: 1!=2 PRINT NO
```
Finally, we got the useful data:

[2,2,1,1] NO

By analyst  more cases, we  get the following parter in other cases:
```
[x,x,x,x,…] YES
[x,x,x,x,…,1] YES
[x+1,x,x,x,…] YES
other pattern—NO
```
##pseudocode:
```
READ input
IF input is not match constrain
EXIT

FILL 26 elements array with 0—each element is used to count char occurrence
FOR each char
	if it is lower case, array[the char-‘a’] increase 1

REMOVE 0 from array

SET founddif to false,repeatvalue to 0, difvalue to 0
IF 2nd equal 1st
	SET repeatvalue to 1st
ELSE 
	SET founddif to true
	IF 3rd is in (1st,2nd)
		SET repeatvalue to 3rd, difvalue to dif(3,(1st,2nd))

		
FOR 4th to last one in array
	IF element not equal repeatvalue 
		IF founddif is true
			PRINT “NO”
			EXIST
		ELSE
			founddif to true
IF founddif is false
	PRINT YES
	EXIT
ELSE
	IF difvalue is 1
	PRINT YES
	EXIT
	ELSE IF difvalue-repeatvalue equal 1
		PRINT YES
	ELSE
		PRINT NO
```
#Pairs

Given N integers, count the number of pairs of integers whose difference is K .

##Input Format

The first line contains N and K. 

The second line contains N numbers of the set. All the N numbers are unique.

##Output Format

An integer that tells the number of pairs of integers whose difference is K.

##Constraints: 
```
1. N<=10^5
2. 0 < K < 10^9
3.Each integer will be greater than 0  and at least K smaller than 2^31-1 .
```
##Sample Input
```
5 2  
1 5 3 4 2  
```
##Sample Output
```
3
```
##Explanation

There are 3 pairs of integers in the set with a difference of 2

##My thinking:
```
5 2  
1 5 3 4 2  

1: 1+2=3, 1-2=-1 ->(1,3)  count++


5: 5+2=7, 5-2=3 -> (5,3) count++

3: 3+2=5, 3-2=1 ->(3,5) (3,1)

4: 4+2=6, 4-2=2 ->(4,2) count++
```
##pseudocode:
```
READ input line with 2 number, 1st as N, 2nd as K
IF N not matchs constraint
EXIT
IF K not matchs constraint
EXIT

READ input line with N numbers
IF amount numbers not equal N
EXIT

PUT all numbers in a integer array
IF Catch exception
EXIT

FOR each element in array as a
	FOR each element b after a
		IF b equal a+2 or b equal a-2
			count++
	END LOOP
END LOOP
```
