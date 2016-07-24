#TapeEquilibrium question:

Minimize the value |(A[0] + … + A[P-1]) – (A[P] + … + A[N-1])|.

##Complexity:

expected worst-case time complexity is O(N);

expected worst-case space complexity is O(N)

[detail](https://github.com/desenG/CodilitySolution/tree/master/TapeEquilibrium)
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

You are given an array of n integers and a positive integer, k. Find and print the number of (i,j) pairs where i < j and ai + aj is evenly divisible by k.
 
##Complexity:

time complexity is O(N^2)

space complexity is O(1)

[detail](https://github.com/desenG/CodilitySolution/tree/master/DivisibleSumPairs)

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

A “valid” string is a string S such that for all distinct characters in S each such character occurs the same number of times in S.

[detail](https://github.com/desenG/CodilitySolution/tree/master/SherlockandValidString)

##Complexity:

time complexity is O(N)

space complexity is O(1)



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

[detail](https://github.com/desenG/CodilitySolution/tree/master/Pairs)


##Complexity:

time complexity is O(N*log(N))

space complexity is O(N)

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
＃PermCheck

Check whether array N is a permutation.

[detail](https://github.com/desenG/CodilitySolution/tree/master/PermCheck)

##pseudocode:
```
FILL 0 to new array B with the same size as A[]
FOR each element
    IF element<1 or element > size A[]
        RETURE 0
    B[element-1]++
    IF A[element-1]>1
        RETURE 0
END LOOP
```

Finally, convert the pseudocode to different language as the following:

1.[Java](https://github.com/desenG/CodilitySolution/blob/master/PermCheck/PermCheck.java)

#MaxCounters
Find the minimal positive integer not occurring in a given sequence.

##My thinking:
For the following example
```
N=5
-111, -112, 2, 3,6
```
What I will do is:
```
SET B=[0,0,0,0,0]
-111: next
-112: next
2: B[2-1]++ -> [0,1,0,0,0]
3: B[3-1]++ -> [0,1,1,0,0]
6: continue

[0,1,1,0,0]
```
So:
1 is result

##pseudocode:
```
IF N equal 1
	IF A[0] equal 1
		RETURN 2
	ELSE
		RETURN 1
SET N integers array with 0 as B
FOR each element
	IF element<1 or element>N 
		Continue
	ELSE 
		B[element-1]++
END LOOP

FOR i 0 to N-1
	if B[i] equal 0
		RETURN i+1
END LOOP
```
Time complexity: O(N)
