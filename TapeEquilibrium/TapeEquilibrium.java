package jpractice;

import java.util.stream.IntStream;

public class TapeEquilibrium {	
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.print(s.solution(new int[]{3,1,2,4,3}));
	}
}

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // SET temp to 2xarray[0]-sum
        // SET min= temp
        // FOR p = 1 to array size
        // 	temp = temp + array[p]x2
        // 	min=min(min, temp)
        int temp=2*A[0]-IntStream.of(A).sum();
        int min=Math.abs(temp);
        for(int i=2; i<A.length-1;i++)
        {
        	temp=temp+2*A[i-1];
        	min=Math.min(min, Math.abs(temp));
        }
		return min;
    }

}
