package jpractice;

import java.util.Scanner;

public class DivisibleSumPairs {

	public static void main(String[] args) {
		//READ 2 numbers with space as separator from console 
		//if Constrain check ok
		//	1st as n, 2nd as k  
		//READ n numbers with space as separator
		//if Constrain check ok
		//	put numbers to array
		Scanner sc=new Scanner(System.in);
		String input = sc.nextLine();
		String[] split = input.split("\\s+");
		int n=0;
		int k;
		if (split.length!=2)
		{
			return;
		}
		try
		{
			n=Integer.parseInt(split[0]);
			k=Integer.parseInt(split[1]);
		}
		catch(NumberFormatException ex)
		{
			return;
		}

		int[] intarr=new int[n];
		input = sc.nextLine();
		String[] split1 = input.split("\\s+");
		if(split1.length<n)
		{
			return;
		}
		for(int i=0;i<n;i++)
		{
			try
			{
				intarr[i]=Integer.parseInt(split1[i]);
			}
			catch(NumberFormatException ex)
			{
				return;
			}
		}
		
		System.out.println(solution(intarr,k));
	}
	
	public static int solution(int[] array,int k)
	{
//		FOR each element except last one as a
//			FOR each element after a as b
//				if (a+b) mod k=0
//					count++
//			END LOOP
//		END LOOP
		int result=0;
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				if((array[i]+array[j])%k==0)
				{
					result++;
				}
			}
		}

		return result;
	}

}
