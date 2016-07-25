package jpractice;

import java.util.Arrays;

public class GenomicRangeQueryNxM {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("GT",new int[]{0, 0, 1},new int[]{0, 1, 1})));//3, 3, 4//(solution("CAGCCTA",new int[]{2, 5, 0},new int[]{4, 5, 6})));//2, 4, 1

	}

    public static int[] solution(String S, int[] P, int[] Q) {
    	// SLICE S to array A
    	// INIT M int array B
        // FOR i 0 to M-1
        // 	SET min to A[P[i]]
        // 	IF P[i] equal Q[i]
        // 		SET B[i] to (min equal ?A, ?C, ?G, ?T :1,2,3,4)
        // 		CONTINUE
        // 	FOR element from A[P[i]] to A[Q[i]]
        // 		IF element < min
        // 			SET min to element
        // 	ENDLOOP
        // 	SET B[i] to (min equal ?A, ?C, ?G, ?T :1,2,3,4)
        // ENDLOOP
        
        // RETURN B
    	char[] A=S.toCharArray();
    	int[] B=new int[P.length];
    	for(int i=0;i<P.length;i++)
    	{
    		int min=A[P[i]];
    		if(P[i]==Q[i])
    		{
    			B[i]=((min=='A')?1:((min=='C')?2:((min=='G')?3:((min=='T')?4:0))));
    			continue;
    		}
    		for(int j= P[i];j<Q[i]+1;j++ )
    		{
    			if(A[j]<min)
    			{
    				min=A[j];
    			}
    		}
			B[i]=((min=='A')?1:((min=='C')?2:((min=='G')?3:((min=='T')?4:0))));
    	}
    	return B;
    }
}
