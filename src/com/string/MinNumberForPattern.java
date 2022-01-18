package com.string;

import java.util.Stack;

/*
 * Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern.
Digits from 1-9 and digits can't repeat.

 

Example 1:

Input:
D
Output:
21
Explanation:
D is meant for decreasing,
So we choose the minimum number
among 21,31,54,87,etc.
 

Example 2:

Input:
IIDDD
Output:
126543
Explanation:
Above example is self- explanatory,
1 < 2 < 6 > 5 > 4 > 3
  I - I - D - D - D
 */

class MinNumberForPattern{
   static String printMinNumberForPattern(String S){
       // code here
        Stack<Integer> st=new Stack<>();
       String ss="";
       for(int i=0;i<=S.length();i++)
       {
           st.push(i+1);
           if(i==S.length() || S.charAt(i)=='I')
           {
             while(st.size()>0)
             {
                 ss+= " "+String.valueOf(st.pop());
             }
           }
       }
       return ss;
   }
   public static void main(String[] args) {
	System.out.println(printMinNumberForPattern("IIDDDDDIIDDD"));
}
}