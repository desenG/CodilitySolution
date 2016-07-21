﻿using System;
using System.Linq;

namespace PracticeCSharp
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			Solution s = new Solution();
			Console.WriteLine(s.solution(new int[]{ 3, 1, 2, 4, 3 }));
		}
	}

	class Solution
	{
		public int solution(int[] A)
		{
			// write your code in Java SE 8
			// SET temp to 2xarray[0]-sum
			// SET min= temp
			// FOR p = 1 to array size
			// 	temp = temp + array[p]x2
			// 	min=min(min, temp)
			int temp = 2 * A[0] - A.Sum();
			int min = Math.Abs(temp);
			for (int i = 2; i < A.Length - 1; i++)
			{
				temp = temp + 2 * A[i - 1];
				min = Math.Min(min, Math.Abs(temp));
			}
			return min;
		}

	}

}
