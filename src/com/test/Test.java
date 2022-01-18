package com.test;

/*
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal 
 * to goal, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j 
and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 */
public class Test {

	public static void main(String[] args) {
		System.out.println(buddyStrings("ab", "ba"));
		
	}
	
	public static boolean buddyStrings(String s, String goal) {
        boolean result = false;

            if (s.length() == goal.length())
            {
                char s1 = 'a',g1 = 'a';
                int i = 0, ssize = s.length(), count = 0;
                while (i<ssize)
                {
                 if(s.charAt(i) != goal.charAt(i))
                 {
                	 
                     if(count ==0)
                     {
                       s1 = s.charAt(i);
                       g1 = goal.charAt(i); 
                       
                         
                         count ++;
                     }
                     else if(count ==1)
                     {
                         if(g1 == s.charAt(i) && s1 == goal.charAt(i))
                         {
                            result = true;    
                         }
                         break;
                     }
                     
                    
                 }
                 i++;
                }
            
        }
        return result;
    }
}
