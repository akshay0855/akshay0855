package com.test.dynamicprogramming;

// Java program to find out maximum
// profit by buying and selling a
// share atmost k times given stock
// price of n days
import java.io.*;

/*
 * alculate the maximum profit gained by selling shares on the ith day in constant time.
profit[t][i] = max(profit [t][i-1], max(price[i] – price[j] + profit[t-1][j])) 
                            for all j in range [0, i-1]
If we carefully notice, 
max(price[i] – price[j] + profit[t-1][j]) 
for all j in range [0, i-1]
can be rewritten as, 
= price[i] + max(profit[t-1][j] – price[j]) 
for all j in range [0, i-1] 
= price[i] + max(prevDiff, profit[t-1][i-1] – price[i-1]) 
where prevDiff is max(profit[t-1][j] – price[j]) 
for all j in range [0, i-2]
So, if we have already calculated max(profit[t-1][j] – price[j]) for all j in range [0, i-2], we can calculate it for j = i – 1 in constant time. In other words, we don’t have to look back in the range [0, i-1] anymore to find out best day to buy. We can determine that in constant time using below revised relation.
profit[t][i] = max(profit[t][i-1], price[i] + max(prevDiff, profit [t-1][i-1] – price[i-1]) 
where prevDiff is max(profit[t-1][j] – price[j]) for all j in range [0, i-2]
Below is its optimized implementation – 
 */

class MaximumProfitKTransaxtionBuyAndSell {

	// Function to find out maximum profit by
	// buying & selling/ a share atmost k times
	// given stock price of n days
	static int maxProfit(int price[], int n, int k) {

		// table to store results of subproblems
		// profit[t][i] stores maximum profit
		// using atmost t transactions up to day
		// i (including day i)
		int profit[][] = new int[k + 1][n + 1];

		// For day 0, you can't earn money
		// irrespective of how many times you trade
		for (int i = 0; i <= k; i++)
			profit[i][0] = 0;

		// profit is 0 if we don't do any
		// transaction (i.e. k =0)
		for (int j = 0; j <= n; j++)
			profit[0][j] = 0;

		// fill the table in bottom-up fashion
		for (int i = 1; i <= k; i++) {
			int prevDiff = Integer.MIN_VALUE;
			for (int j = 1; j < n; j++) {
				prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - price[j - 1]);
				profit[i][j] = Math.max(profit[i][j - 1], price[j] + prevDiff);
			}
		}

		return profit[k][n - 1];
	}

// Driver code
	public static void main(String[] args) {
		int k = 3;
		int price[] = { 12, 14, 17, 10, 14, 13, 12, 15 };

		int n = price.length;

		System.out.println("Maximum profit is: " + maxProfit(price, n, k));
	}
}

// This code is contributed by Sam007
