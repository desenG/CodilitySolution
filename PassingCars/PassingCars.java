package jpractice;

public class PassingCars {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{0,0,0,1,1,1}));

	}
	
    public static int solution(int[] A) {
//    	RETRIEVE amount of 1 as amount1, and amount of 0 as amount0
//    	INIT count=0
//    	INIT i=0
//    	WHILE amount0>0
//    		IF A[i] equal 0
//    			amount0—
//    			count+=amount1
//    			IF(count>1,000,000,000)
//    				count=-1
//    				BREAK
//    		ELSE
//    			amount1—
//    		IF amount1==0 
//    			BREAK
//    		i++;
//    	ENDWHILE
//    	RETURN count
    	int amount0=0,amount1=0;
    	for(int a:A)
    	{
    		if(a==0)
    		{
    			amount0++;
    		}
    		if(a==1)
    		{
    			amount1++;
    		}
    	}
    	
    	int count = 0;
    	int i=0;
    	while(amount0>0)
    	{
    		if(A[i]==0)
    		{
    			amount0--;
    			count+=amount1;
    		}
    		if(A[i]==1)
    		{
    			amount1--;
    		}
    		
			if(amount1==0)
			{
				break;
			}
			
    		i++;
    	}
    	
    	return count;
    }
}
