package com.array;


/*
 * 
 * Sliding Window Maximum (Maximum of all subarrays of size k)

Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.

Examples : 

Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
Output: 3 3 4 5 5 5 6
Explanation: 
Maximum of 1, 2, 3 is 3
Maximum of 2, 3, 1 is 3
Maximum of 3, 1, 4 is 4
Maximum of 1, 4, 5 is 5
Maximum of 4, 5, 2 is 5 
Maximum of 5, 2, 3 is 5
Maximum of 2, 3, 6 is 6

Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4 
Output: 10 10 10 15 15 90 90
Explanation:
Maximum of first 4 elements is 10, similarly for next 4 
elements (i.e from index 1 to 4) is 10, So the sequence 
generated is 10 10 10 15 15 90 90


 * This method works on finding three max elements and updating them rigorously.

 Approach: This method is based on finding three max elements and printing the first max from every subarray for every new element that enters and leaves the subarray.



Algorithm:

       1. Run a loop from index 0 to k-1 to find the first, second, and third max 
       (say maxA, maxB, and maxC)

       2. Print maxA.

       3. Run a loop from k to n-1

                     : Update maxA, maxB, and maxC by every element that enters the window of length
                      of k.

                     : if maxA matches the element that is being removed from the window replace maxA
                      to maxB

                     : print maxA
 */
class SlidingWindowMaximum {

	static void printKMax(int[] arr, int n, int k) {
		int i, maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;

		// base condition
		// if no subarrays needs to be formed
		if (k == 1 || k == n) {
			for (i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
			return;
		}

		// traverse k elements to find
		// find second and third largest elements
		for (i = 0; i < k; i++) {
			if (maxA < arr[i]) {
				maxC = maxB;
				maxB = maxA;
				maxA = arr[i];
			} else if (maxB < arr[i]) {
				maxC = maxB;
				maxB = arr[i];
			} else if (maxC < arr[i])
				maxC = arr[i];
		}
		System.out.print(maxA + " ");

		// traverse from remaining elements
		for (i = k; i < n; i++) {
			// reset first second and third largest elements
			// in response to new incoming elements
			if (maxA < arr[i]) {
				maxC = maxB;
				maxB = maxA;
				maxA = arr[i];
			} else if (maxB < arr[i]) {
				maxC = maxB;
				maxB = arr[i];
			} else if (maxC < arr[i])
				maxC = arr[i];

			// if the first biggest we earlier found
			// is matching from the element that
			// needs to be removed from the subarray
			if (arr[i - k] == maxA) {
				// reset first biggest to second and second to third
				maxA = maxB;
				maxB = maxC;
			}
			System.out.print(maxA + " ");
		}
	}

// drivers code
	public static void main(String[] args) {
		int arr[] = { 1, 5, 2, 7, 8, 4, 7, 2 };
		int k = 3;
		int n = arr.length;
		printKMax(arr, n, k);
	}
}

// This code is contributed by umadevi9616
