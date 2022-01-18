package com.array;

// Java implementation of the approach
import java.util.*;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6

Explanation:
The structure is like below


Trap "1 unit" between first 1 and 2, "4 units" between
first 2 and 3 and "1 unit" between second last 1 and last 2

 * Method 5 (Two Pointer Approach)

Approach: At every index, The amount of rainwater stored is the difference between current index height and a minimum of left max height and right max-height
Algorithm :
Take two pointers l and r. Initialize l to the starting index 0 and r to the last index n-1
Since l is the first element, left_max would be 0, and right max for r would be 0
While l <= r , iterate the array . We have two possible conditions

Condition1 : left_max <= right max
Consider Element at index l
Since we have traversed all elements to the left of l, left_max is known 
For the right max of l, We can say that the right max would  always be >= current r_max here
So, min(left_max,right_max) would always equal to left_max in this case
Increment l

Condition2 : left_max >  right max
Consider Element at index r
Since we have traversed all elements to the right of r, right_max is known
For the left max of l, We can say that the left max would  always be >= current l_max here
So, min(left_max,right_max) would always equal to right_max in this case
Decrement r

Implementation:
 */
class MaxWater {

	static int maxWater(int[] arr, int n) {

		// indices to traverse the array
		int left = 0;
		int right = n - 1;

		// To store Left max and right max
		// for two pointers left and right
		int l_max = 0;
		int r_max = 0;

		// To store the total amount
		// of rain water trapped
		int result = 0;
		while (left <= right) {

			// We need check for minimum of left
			// and right max for each element
			if (r_max <= l_max) {

				// Add the difference between
				// current value and right max at index r
				result += Math.max(0, r_max - arr[right]);

				// Update right max
				r_max = Math.max(r_max, arr[right]);

				// Update right pointer
				right -= 1;
			} else {

				// Add the difference between
				// current value and left max at index l
				result += Math.max(0, l_max - arr[left]);

				// Update left max
				l_max = Math.max(l_max, arr[left]);

				// Update left pointer
				left += 1;
			}
		}
		return result;
	}

// Driver code
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;
		System.out.print(maxWater(arr, n));
	}
}

// This code is contributed by rutvik_56.
