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
#PermCheck

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

#MissingInteger
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
RETURN N+1
```
Time complexity: O(N)

#PassingCars
Count the number of passing cars on the road.
##My first thinking:
```
For array [x] -> 0
For array [0,1,0,1,1]

0: [1.0,1,1] has 3 1s. count+3
1: next
0: [1,1] has 2 1s. count+2
```
##pseudocode:
```
IF array size equal 1
	RETURN 0;
FOR each element as a
	IF a not equal 0 Continue;
	FOR each element after b
		IF(b equal 1) count ++
			IF(count>1,000,000,000)
				RETURN -1
	END LOOP
END LOOP
RETURN count
```
Obviously, it is not a good solution in term of time complexity.
##My another thinking to enhance the performance:
```
For array [0,1,0,1,1]

The array has 2 0s and 3 1s.

0: count+3; 1 0s left
1: 3-1=2
0: count+2; none 0s left Exit;
```

##pseudocode:
```
RETRIEVE amount of 1 as amount1, and amount of 0 as amount0
INIT count=0
INIT i=0
WHILE amount0>0
	IF A[i] equal 0
		amount0—
		count+=amount1
		IF(count>1,000,000,000)
			RETURN -1
	ELSE
		amount1—
	IF amount1==0 
		BREAK
	i++;
ENDWHILE
RETURN count
```
##Time complexity:
O(N)
Finally, convert the pseudocode to different language as the following:

1.[Java](https://github.com/desenG/CodilitySolution/tree/master/PassingCars)

#GenomicRangeQuery
Find the minimal nucleotide from a range of sequence DNA.

[detail](https://github.com/desenG/CodilitySolution/tree/master/GenomicRangeQuery)
##My first thinking
```
Solution1: P[0] = 2    Q[0] = 4: [G,C,C] -> [3,2,2] -> 2
Solution2: P[0] = 2    Q[0] = 4: IN [G,C,C], C in min value -> So C (2)
```
We can see solution 2 is better.
##pseudocode:
```
SLICE S to array A
INIT M int array B
FOR i 0 to M-1
	SET min to A[P[i]]
	IF P[i] equal Q[i]
		SET B[i] to (min equal ?A, ?C, ?G, ?T :1,2,3,4)
		CONTINUE:
	FOR element from A[P[i]+1] to A[Q[i]]
		IF element < min
			SET min to element
	ENDLOOP
	SET B[i] to (min equal ?A, ?C, ?G, ?T :1,2,3,4)
ENDLOOP

RETURN B
```
Time complexity:
O(N * M)

Finally, convert the pseudocode to different language as the following:

1.[Java](https://github.com/desenG/CodilitySolution/blob/master/GenomicRangeQuery/GenomicRangeQueryNxM.java)

It is not great solution. 

I found another solution.

##Solution3:
For A [CAGCCTA] :
```
2A3C1G1T
[2,3,1,1]
for i 0 to N
i=0, A[0]=C -> [2,2,1,1] 
i=1, A[1]=A -> [1,2,1,1]
i=2, A[2]=G -> [1,2,0,1]
i=3, A[3]=C -> [1,1,0,1]
i=4, A[4]=C -> [1,0,0,1]
i=5, A[5]=T -> [1,0,0,0]
i=6, A[6]=A -> [0,0,0,0]
```
So we get a array of array:
```
[
0:[2,3,1,1]
1:[2,2,1,1] 
2:[1,2,1,1]
3:[1,2,0,1]
4:[1,1,0,1]
5:[1,0,0,1]
6:[1,0,0,0]
7:[0,0,0,0]
]
```
```
P[0] = 2    Q[0] = 4: [1,2,1,1]-[1,1,0,1]=[0,1,1,0] ->2
P[1] = 5    Q[1] = 5: [1,0,0,1] -> 1
P[0] = 0    Q[0] = 2: [2,3,1,1]-[1,2,1,1]=[1,1,0,0] ->1
```
##pseudocode
```
SLICE S to array A
INIT result to a array
INIT amountA to 0,amountC to 0, amountG to 0, amountT to 0
FOR i 0 to N-1
	IF(A[i]) equal A
		amountA++;
	IF(A[i]) equal C
		amountC++;
	IF(A[i]) equal G
		amountG++;
	IF(A[i]) equal T
		amountT++;	
ENDLOOP

INIT C array of array
SET C[0] to [amountA,amountC,amountG,amountT]
FOR i 0 to N-1
	IF(A[i]) equal A
		SET C[i+1] to [amountA-1,amountC,amountG,amountT]
	IF(A[i]) equal C
		SET C[i+1] to [amountA,amountC-1,amountG,amountT]
	IF(A[i]) equal G
		SET C[i+1] to [amountA,amountC,amountG-1,amountT]
	IF(A[i]) equal T
		SET C[i+1] to [amountA,amountC,amountG,amountT-1]
ENDLOOP

FOR i 0 to M-1
	IF P[i] equal Q[i]
		IF A[P[i]] equal 'A'
			SET result[i] to 1
		ELSE IF A[P[i]] equal 'C'
			SET result[i] to 2
		ELSE IF A[P[i]] equal 'G'
			SET result[i] to 3
		ELSE IF A[P[i]] equal 'T'
			SET result[i] to 4
	ELSE
		IF C[P[i]][0]-C[Q[i]+1][0]>0
			SET result[i] to 1
		ELSE IF C[P[i]][1]-C[Q[i]+1][1]>0
			SET result[i] to 2
		ELSE IF C[P[i]][2]-C[Q[i]+1][2]>0
			SET result[i] to 3
		ELSE IF C[P[i]][3]-C[Q[i]+1][3]>0
			SET result[i] to 4
ENDLOOP
RETURN result		
```		 
Time complexity:
O(N + M)

Finally, convert the pseudocode to different language as the following:

1.[Java](https://github.com/desenG/CodilitySolution/blob/master/GenomicRangeQuery/GenomicRangeQueryNplusM.java)

#SUM Fibonacci number

#For example: index=3
sum=1+1+2+3=7

##My thinking

sum=1, pre=0, current=1

1:  temp=pre=0, pre=current=1, curent=temp+curent=0+1=1, sum+=curent=1+1

2:  temp=pre=1, pre=current=1, curent=temp+curent=1+1=2, sum+=curent=1+1+2

3:  temp=pre=1, pre=current=1, curent=temp+curent=1+2=3, sum+=curent=1+1+2+3

Pseudocode:
```
SET sum to 1, pre to 0, current to 1, temp to 0
FOR i 1 to index
	SET temp to pre
	SET pre to current
	SET current to temp+current
	SET sum+=current
ENDLOOP
```
1.[Java](https://github.com/desenG/CodilitySolution/blob/master/Fibonacci/Fibonacci.java)

