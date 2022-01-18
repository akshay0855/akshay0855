package com.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t of lengths m and n respectively, 
 * return the minimum window substring of s such that every character
 *  in t (including duplicates) is included in the window.
 *   If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 */
class MinWindowSunstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        String ans = "";
        int anslen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int counter = map.size();
        int j = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) counter--;
            }
            
            while (counter == 0) {
                String sub = s.substring(j, i+1);
                if (anslen > sub.length()) {
                    ans = sub;
                    anslen = ans.length();
                }
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) counter++;
                }
                j++;
            }
        }
        return ans;
    }
}