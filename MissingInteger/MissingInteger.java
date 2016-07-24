package jpractice;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {

		System.out.println(solution(new int[]{1,2,3}));
	}
	
    public static int solution(int[] A) {
//    	IF A[0] equal 1
//			RETURN 2
//		ELSE
//			RETURN 1

//    	SET N integers array with 0 as B
//    	FOR each element
//	    	IF element<1 or element>N 
//	    		Continue
//	    	ELSE 
//	    		B[element-1]++
//	    END LOOP
//	
//	    FOR i 0 to N-1
//	    	if B[i] equal 0
//	    		RETURN i+1
//	    END LOOP
//    	RETURN N+1
    	if(A.length==1)
    	{
    		if(A[0]==1)
    		return 2;		
    		return 1;
    	}
    	int [] B=new int[A.length];
    	Arrays.fill(B, 0);
    	for(int e:A)
    	{
    		if(e<1||e>A.length)
    			continue;
    		else
    			B[e-1]++;
    	}
    	
    	for(int i=0;i<A.length;i++)
    	{
    		if(B[i]==0)
    		{
    			return i+1;
    		}
    	}
    	
    	return A.length+1;
    }
}
