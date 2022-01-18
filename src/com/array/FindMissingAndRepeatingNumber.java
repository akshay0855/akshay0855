package com.array;

import java.util.HashSet;

/*
 * Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
 */
public class FindMissingAndRepeatingNumber {
	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 4, 6, 7 };

		int n = 7;
		int actualSum = (n * (n + 1)) / 2;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!set.contains(input[i])) {
				set.add(input[i]);
				actualSum -= input[i];
			} else
				System.out.println("Repeating element is : " + input[i]);
		}

		// 28 - 27
		System.out.println("Missing element is : " + actualSum);
	}

}
