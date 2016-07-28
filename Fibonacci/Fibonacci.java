package jpractice;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(0));
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
	}
	
	public static int solution(int index)
	{
		int sum=1,pre=0,current=1,temp=0;
		for(int i=1;i<index+1;i++)
		{
			temp=pre;
			pre=current;
			current=temp+current;
			sum+=current;
		}
		return sum;
	}

}
