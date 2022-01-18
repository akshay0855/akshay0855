package com.twodmatrix;
// Java program to search an element in row-wise
// and column-wise sorted matrix

/*
 * Search in a row wise and column wise sorted matrix
Difficulty Level : Medium
Last Updated : 16 Nov, 2021
Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order. The designed algorithm should have linear time complexity. 

Example: 



Input: mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output: Found at (2, 1)
Explanation: Element at (2,1) is 29

Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 100
Output : Element not found
Explanation: Element 100 is not found
 */

class SearchInSortedMatrix {
	static int search(int[][] mat, int n, int x)
	  {
	    if (n == 0)
	      return -1;
	 
	    // traverse through the matrix
	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < n; j++)
	        // if the element is found
	        if (mat[i][j] == x) {
	          System.out.print("Element found at ("
	                           + i + ", " + j
	                           + ")\n");
	          return 1;
	        }
	    }
	 
	    System.out.print(" Element not found");
	    return 0;
	  }
	  public static void main(String[] args)
	  {
	    int mat[][] = { { 10, 20, 30, 40 },
	                   { 15, 25, 35, 45 },
	                   { 27, 29, 37, 48 },
	                   { 32, 33, 39, 50 } };
	 
	    search(mat, 4, 29);
	  }
}
