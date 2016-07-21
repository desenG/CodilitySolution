//
//  main.m
//  objc-practice
//
//  Created by DesenGuo on 2016-07-09.
//  Copyright © 2016 ideaweddinghome. All rights reserved.
//

int solution(int* A,size_t count) {
    // SET temp to 2xarray[0]-sum
    // SET min to |temp|
    // FOR p = 2 to array size-2
    // 	temp = temp + array[p-1]x2
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


int main(int argc, const char * argv[]) {
    @autoreleasepool {

        int a[] = {3,1,2,4,3};
        int result=solution(a,sizeof a / sizeof (int));
        NSLog(@"%d",result);
        
    }
    return 0;
}
