package com.array;

import java.util.HashSet;

/*
 * Given a Sudoku Board configuration, check whether it is valid or not.

Examples: 

Input: 
    [5 3 - - 7 - - - -]
    [6 - - 1 9 5 - - -]
    [- 9 8 - - - - 6 -]
    [8 - - - 6 - - - 3]
    [4 - - 8 - 3 - - 1]
    [7 - - - 2 - - - 6]
    [- 6 - - - - 2 8 -]
    [- - - 4 1 9 - - 5]
    [- - - - 8 - - 7 9]

Output: True
 */
public class IsValidSudoki {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][] {
	        { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
	        { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
	        { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
	        { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
	        { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
	        { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
	        { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
	        { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
	        { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
	    };
	 
	    System.out.println((isValidSudoku(board, 9) ?
	                       "YES" : "NO"));
	}

	static boolean isValidSudoku(char[][] input, int n) {
		HashSet<String> uniqueElements = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] != '.') {

					if(!uniqueElements.add("ROW"+i+input[i][j]) || !uniqueElements.add("COL"+j+input[i][j])
							|| !uniqueElements.add("BOX"+(i/3)*3+j/3+input[i][j]))
					{
						return false;
					}
				}
			}
		}

		return true;
	}

}
