package com.test.dynamicprogramming;

public class AddBoldTagsString {

	/*
	 * Medium Given a string s and a list of strings dict, you need to add a closed
	 * pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict.
	 * If two such substrings overlap, you need to wrap them together by only one
	 * pair of closed bold tag. Also, if two substrings wrapped by bold tags are
	 * consecutive, you need to combine them.
	 * 
	 * Example 1: Input: s = "abcxyz123" dict = ["abc","123"] Output:
	 * "<b>abc</b>xyz<b>123</b>"Input: s = "aaabbcc" dict = ["aaa","aab","bc"]
	 * Output: "<b>aaabbc</b>c"
	 * 
	 * Example 2: Input: s = "aaabbcc" dict = ["aaa","aab","bc"] Output:
	 * "<b>aaabbc</b>c"
	 * 
	 * 
	 * Solution:
	 * 
	 * Iterate over input string, and each word check if word in present in input
	 * string with that index than fill the boolean array true for the lenght of
	 * word starting from the index [1110000] repeat the steps and boolean array
	 * will be like [111000111]
	 * 
	 * All the ones should be bold
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addTags("abcxyz123", new String[] { "abc", "123" }));
		System.out.println(addTags("aaabbcc", new String[] { "aaa", "aab", "bc" }));
	}

	static String addTags(String input, String[] words) {
		boolean[] flags = new boolean[input.length()];
		int j = 0, end = 0;

		for (int i = 0; i < input.length(); i++) {
			for (String word : words) {
				j = i;
				if (input.startsWith(word, i)) {
					end = j + word.length();
					while (j < end) {
						flags[j++] = true;

					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (!flags[i]) {
				sb.append(input.charAt(i));
			} else {
				sb.append("<b>");
				sb.append(input.charAt(i));
				j = i + 1;
				while (j < input.length() && flags[j]) {
					sb.append(input.charAt(j));
					j++;
				}
				sb.append("/<b>");
				i = j - 1;

			}
		}

		return sb.toString();

	}

}
