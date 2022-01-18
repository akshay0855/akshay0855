package com.string;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Given a string return its first non repeating character
 */
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFirstNonRepChar("loveleetcode"));
	}

	public static Character getFirstNonRepChar(String args) {
		Character ch = null;
		// LinkedHashMap maintains insertion order
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (Character c : args.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (Character c : map.keySet()) {
			if (map.get(c) == 1) {
				ch = c;
				break;
			}
		}
		return ch;
	}

}
