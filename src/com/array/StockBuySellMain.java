package com.array;

public class StockBuySellMain {

	/*
	 * Given an array of integers representing stock price on a single day, find max
	 * profit that can be earned by 1 transaction. So you need to find a pair
	 * (buyDay,sellDay) where buyDay < = sellDay and it should maximize the profit.
	 * For example: 1 2 3 4 5
	 * 
	 * int arr[]={14, 12, 70, 15, 99, 65, 21, 90}; Max profit can be gain by buying
	 * on 1st day(0 based indexing) and sell on the 4th day. Max profit = 99-12 =87
	 * 
	 * Lets say we have array arr[] of stock prices. We will track two variables
	 * :lowestPriceTillThatDayand maxProfit.
	 * 
	 * lowestPriceTillThatDay will be initialise to arr[0]. Iterate over stock price
	 * array arr[] If current element is greater than lowestPriceTillThatDay
	 * calculate profit. If profit is greater than maxProfit then update the
	 * maxProfit. If current element is lesser than lowestPriceTillThatDay update
	 * lowestPriceTillThatDay with current element. We will get maxProfit in the
	 * end.
	 */
	public static void main(String[] args) {
		int arr[] = { 14, 12, 70, 15, 99, 65, 21, 90 };
		System.out.println("Maximum profit :" + calculateMaxProfit(arr));

	}

	public static int calculateMaxProfit(int[] arr) {
		int lowestPriceTillThatDay = arr[0];
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int profit = 0;
			if (arr[i] > lowestPriceTillThatDay) {
				profit = arr[i] - lowestPriceTillThatDay;
				if (profit > maxProfit) {
					maxProfit = profit;
				}
			} else {
				lowestPriceTillThatDay = arr[i];
			}
		}
		return maxProfit;
	}

}