package jpractice;

public class PermCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solution(new int[]{1,1}));
	}
	
    public static int solution(int[] A) {
//    	FILL 0 to new array B with the same size as A[]
//		FOR each element
//			IF element<1 or element > size A[]
//				RETURE 0
//			B[element-1]++
//			IF A[element-1]>1
//				RETURE 0
//		END LOOP
    	int[] B=new int[A.length];
    	for(int i=0;i<A.length;i++)
    	{
    		if(A[i]<1 || A[i]>A.length) return 0;
    		B[A[i]-1]++;
    		if(B[A[i]-1]>1) return 0;
    	}
    	return 1;
    }

}
