package com.array;
// Java program to count number of ways

// to reach n't stair when a person
// can climb 1, 2, ..m stairs at a time

class NStairProblem {

	// 1 0r 2 stairs at time
	/*
	 * Problem: There are N stairs, a person standing at the bottom wants to reach
	 * the top. The person can climb either 1 stair or 2 stairs at a time. Count the
	 * number of ways, the person can reach the top
	 */
	static int NStairsAtATime(int n, int m) {
		int res[] = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[n];

	}

	// A recursive function used by countWays
	static int countWaysUtil(int n, int m) {
		int res[] = new int[n];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < n; i++) {
			res[i] = 0;
			for (int j = 1; j <= m && j <= i; j++)
				res[i] += res[i - j];
		}
		return res[n - 1];
	}

	// Returns number of ways to reach s'th stair
	static int countWays(int s, int m) {
		return countWaysUtil(s + 1, m);
	}

	// Driver method
	public static void main(String[] args) {
		int s = 4, m = 2;
		System.out.println("Number of ways = " + countWays(s, m));

		int n;
		n = 5;

		// Here n/2 is done to count the number 2's
		// in n 1 is added for case where there is no 2.
		// eg: if n=4 ans will be 3.
		// {1,1,1,1} set having no 2.
		// {1,1,2} ans {2,2} (n/2) sets containing 2.
		System.out.print("Number of ways when order of steps " + "does not matter is : " + (1 + (n / 2)));
	}

}