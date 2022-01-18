package com.array;

// Java program to count subarrays having
// product less than k.
import java.util.*;

/*
 * Given an array of positive numbers, calculate the number of possible contiguous 
 * subarrays having product lesser than a given number K.

Examples : 

Input : arr[] = [1, 2, 3, 4] 
        K = 10
Output : 7
The subarrays are {1}, {2}, {3}, {4}
{1, 2}, {1, 2, 3} and {2, 3}

Input  : arr[] = [1, 9, 2, 8, 6, 4, 3] 
         K = 100
Output : 16

Input  : arr[] = [10, 5, 2, 6] 
         K = 100
Output : 8


 * We can optimized approach is based on sliding window technique (Note that we need to find contiguous parts)
Firstly, according to the description, all elements in the array are strictly positive. Also let’s assume that the product of all array elements always fits in 64-bit integer type. Taking these two points into consideration, we are able to multiply and divide array’s elements safety (no division by zero, no overflows).

Let’s see how to count the desired amount. Assume, we have a window between start and end, and the product of all elements of it is p < k. Now, let’s try to add a new element x. There are two possible cases.

Case 1. p*x < k 
This means we can move the window’s right bound one step further. How many contiguous arrays does this step produce? It is: 1 + (end-start).
Indeed, the element itself comprises an array, and also we can add x to all contiguous arrays which have right border at end. There are as many such arrays as the length of the window.

Case 2. p*x >= k
This means we must first adjust the window’s left border so that the product is again less than k. After that, we can apply the formula from Case 1.

Example :  

  a = [5, 3, 2]
  k = 16
 
  counter = 0
  Window: [5]
  Product: 5

  5  counter += 1+ (0-0)
  counter = 1
  Window: [5,3]
  Product: 15

  15  counter += 1 + (1-0)
  counter = 3
  Window: [5,3,2]
  Product: 30

  30 > 16 --> Adjust the left border
  New Window: [3,2]
  New Product: 6

  6  counter += 1 + (2-1)
  counter = 5
  Answer: 5 
 */
class CountSubArrayProductLessThanK {

	static int countSubArrayProductLessThanK(ArrayList<Integer> a, long k) {
		int n = a.size();
		long p = 1;
		int res = 0;
		for (int start = 0, end = 0; end < n; end++) {

			// Move right bound by 1 step.
			// Update the product.
			p *= a.get(end);

			// Move left bound so guarantee that
			// p is again less than k.
			while (start < end && p >= k)
				p /= a.get(start++);

			// If p is less than k, update the counter.
			// Note that this is working even for
			// (start == end): it means that the
			// previous window cannot grow anymore
			// and a single array element is the only
			// addendum.
			if (p < k) {
				int len = end - start + 1;
				res += len;
			}
		}

		return res;
	}

	// Drive Code
	public static void main(String[] args) {
		// Function Calls
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		System.out.println(countSubArrayProductLessThanK(al, 10));

		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(1);
		al1.add(9);
		al1.add(2);
		al1.add(8);
		al1.add(6);
		al1.add(4);
		al1.add(3);
		System.out.println(countSubArrayProductLessThanK(al1, 100));

		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(5);
		al2.add(3);
		al2.add(2);
		System.out.println(countSubArrayProductLessThanK(al2, 16));

		ArrayList<Integer> al3 = new ArrayList<Integer>();
		al3.add(100);
		al3.add(200);
		System.out.println(countSubArrayProductLessThanK(al3, 100));

		ArrayList<Integer> al4 = new ArrayList<Integer>();
		al4.add(100);
		al4.add(200);
		System.out.println(countSubArrayProductLessThanK(al3, 101));
	}
}