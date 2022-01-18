package com.string;

/*
 * Given a string, Your task is to  complete the function encode that returns the run length encoded string for the given string.
eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
You are required to complete the function encode that takes only one argument the string which is to be encoded and returns the encoded string.
 */
public class EncodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "wwwwaaadexxxxxx";
		char[] charArr = s.toCharArray();

		int j = 1;

		for (int i = 1; i < s.length(); i++) {
			if (charArr[i-1] == charArr[i]) {
				j++;
			} else {
				
				System.out.print(charArr[i-1]);
				System.out.print(j);
				j = 1;
			}
			if(i == s.length()-1)
			{
				System.out.print(charArr[i-1]);
				System.out.print(j);
			}
		}
		
	}
	
	

}
