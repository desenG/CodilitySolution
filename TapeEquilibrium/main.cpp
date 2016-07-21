//
//  main.cpp
//  cpp_practice
//
//  Created by DesenGuo on 2016-03-13.
//  Copyright © 2016 divecommunications. All rights reserved.
//


#include <vector>
#include <iostream>
#include <numeric>

using namespace std;

int solution(int* A,size_t count); // prototype


int main(int argc, const char * argv[]) {

    int a[] = {3,1,2,4,3};
    int result=solution(a,sizeof a / sizeof (int));
    cout << result<<endl;
    return(0);
}

int solution(int* A,size_t count) {
    // SET temp to 2xarray[0]-sum
    // SET min to |temp|
    // FOR p = 1 to array size
    // 	temp = temp + array[p]x2
    // 	min=min(min, |temp|)
    int sum = 0;
    for (int i=0;i<count;i++)
    {
        sum=sum+A[i];
    }
    
    int temp=A[0]*2-sum;
    int min=abs(temp);
    for(int p=2;p<count-1;p++)
    {
        temp=temp+A[p-1]*2;
        min=abs(temp);
    }
    return min;
}