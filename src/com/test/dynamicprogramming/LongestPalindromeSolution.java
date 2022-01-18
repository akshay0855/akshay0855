package com.test.dynamicprogramming;

/*
 * Given a string s, return the longest palindromic substring in s.

   Example 1:

   Input: s = "babad"
   Output: "bab"
   Note: "aba" is also a valid answer.
   
   length =5
   
     0  1  2  3  4
     b  a  b  a  d
 0 b t  
 1 a    t 
 2 b       t
 3 a          t
 4 d             t
 */

public class LongestPalindromeSolution {

	 public String longestPalindrome(String s) {
		 
		 if(s == "")
		 {
			 return "";
		 }
		 int n = s.length();
		 boolean[][] arr = new boolean[n][n];
		 int start = 0;
		 int end = 0;
		 int length = 1;
		 for (int i =0; i<n;i++)
			 arr[i][i] = true;
		 
		 for (int i= n-2;i>= 0; i--)
		 {
			 for(int j = i+1; j<n;j++)
			 {
				 if (s.charAt(i) == s.charAt(j))
				 {
					 if(arr[i+1][j-1] || j-i == 1)
					 {
						 arr[i][j] = true;
						 if(length < j-i+1) 
						 {
							 length = j-i+1;
						     start = i;
						     end = j;
						 }
					 }
				 }
			 }
		 }
		 
		return s.substring(start,end+1); 
		 	 
		
	    }
	 
	public static void main(String[] args) {
		String s = "abcbdkaad";
		System.out.println(new LongestPalindromeSolution().longestPalindrome(s ));

	}

}
