package jpractice;

import java.util.Arrays;

public class GenomicRangeQueryNplusM {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("GT",new int[]{0, 0, 1},new int[]{0, 1, 1})));//3, 3, 4//(solution("CAGCCTA",new int[]{2, 5, 0},new int[]{4, 5, 6})));//2, 4, 1

	}
	
    public static int[] solution(String S, int[] P, int[] Q) {
//    	SLICE S to array A
//    	INIT result to a array
//    	INIT amountA to 0,amountC to 0, amountG to 0, amountT to 0
//    	FOR i 0 to N-1
//    		IF(A[i]) equal A
//    			amountA++;
//    		IF(A[i]) equal C
//    			amountC++;
//    		IF(A[i]) equal G
//    			amountG++;
//    		IF(A[i]) equal T
//    			amountT++;	
//    	ENDLOOP
//
//    	INIT C array of array
//    	SET C[0] to [amountA,amountC,amountG,amountT]
//    	FOR i 0 to N-1
//    		IF(A[i]) equal A
//    			SET C[i+1] to [amountA-1,amountC,amountG,amountT]
//    		IF(A[i]) equal C
//    			SET C[i+1] to [amountA,amountC-1,amountG,amountT]
//    		IF(A[i]) equal G
//    			SET C[i+1] to [amountA,amountC,amountG-1,amountT]
//    		IF(A[i]) equal T
//    			SET C[i+1] to [amountA,amountC,amountG,amountT-1]
//    	ENDLOOP
//
//    	FOR i 0 to M-1
//    		IF P[i] equal Q[i]
//    			IF A[P[i]] equal 'A'
//    				SET result[i] to 1
//    			ELSE IF A[P[i]] equal 'C'
//    				SET result[i] to 2
//    			ELSE IF A[P[i]] equal 'G'
//    				SET result[i] to 3
//    			ELSE IF A[P[i]] equal 'T'
//    				SET result[i] to 4
//    		ELSE
//    			IF C[P[i]][0]-C[Q[i]+1][0]>0
//    				SET result[i] to 1
//    			ELSE IF C[P[i]][1]-C[Q[i]+1][1]>0
//    				SET result[i] to 2
//    			ELSE IF C[P[i]][2]-C[Q[i]+1][2]>0
//    				SET result[i] to 3
//    			ELSE IF C[P[i]][3]-C[Q[i]+1][3]>0
//    				SET result[i] to 4
//    	ENDLOOP
//    	RETURN result
    	char[] A=S.toCharArray();

    	int[] result=new int[P.length];
    	int amountA=0;
    	int amountC=0;
    	int amountG=0;
    	int amountT=0;
    	int[][] C=new int[A.length+1][4];
    	
    	for(char a:A)
    	{
    		if(a=='A') amountA++;
    		else if(a=='C') amountC++;
    		else if(a=='G') amountG++;
    		else if(a=='T') amountT++;
    	}
		C[0]=new int[]{amountA,amountC,amountG,amountT};
    	for(int i=0;i<A.length;i++)
    	{
    		if(A[i]=='A') 
    		{
    			amountA--;
    		}
    		else if(A[i]=='C') 
    		{
    			amountC--;
    		}
    		else if(A[i]=='G') 
    		{
    			amountG--;
    		}
    		else if(A[i]=='T') 
    		{
    			amountT--;
    		}
    		C[i+1]=new int[]{amountA,amountC,amountG,amountT};
    	}
    	for(int i=0;i<P.length;i++)
    	{
    		if(P[i]==Q[i])
    		{
    			if(A[P[i]]=='A')
    				result[i]=1;
    			else if (A[P[i]]=='C')
    				result[i]=2;
    			else if (A[P[i]]=='G')
    				result[i]=3;
    			else if (A[P[i]]=='T')
    				result[i]=4;
    		}
    		else
    		{
    			if((C[P[i]][0]-C[Q[i]+1][0])>0)
    			{
    				result[i]=1;
    			}
    			else if((C[P[i]][1]-C[Q[i]+1][1])>0)
    			{
    				result[i]=2;
    			}
    			else if((C[P[i]][2]-C[Q[i]+1][2])>0)
    			{
    				result[i]=3;
    			}
    			else if((C[P[i]][3]-C[Q[i]+1][3])>0)
    			{
    				result[i]=4;
    			}
    		}
    	}
    	return result;
    }
}
