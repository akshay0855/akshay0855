package com.array;

/*
 * Given an array of positive integers nums and a positive integer target, 
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 *  of which the sum is greater than or equal to target. If there is no such subarray,
 *   return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Iterate:
val condit   count sum  i
 3    1<6  -  2    5    0
 1    2<6     3    6    0
 2    3<6     2    4    1
 2    3<6     3    6    1
 4    4<6     2    3    2
 4    4<6     2    2    3  -- 2
 4    4<6     3    6    3
 3    5<6     2    4    4
 3
 
 
Val : 3 count: 2 , Sum : 5 , i : 0 , minc : 2147483647
Val : 1 count: 3 , Sum : 6 , i : 0 , minc : 2147483647
Val : 2 count: 2 , Sum : 4 , i : 1 , minc : 2147483647
Val : 2 count: 3 , Sum : 6 , i : 1 , minc : 2147483647
Val : 4 count: 2 , Sum : 3 , i : 2 , minc : 2147483647
Val : 4 count: 1 , Sum : 2 , i : 3 , minc : 2
Val : 4 count: 2 , Sum : 6 , i : 3 , minc : 2
Val : 3 count: 1 , Sum : 4 , i : 4 , minc : 2
Val : 3 count: 0 , Sum : 0 , i : 5 , minc : 1
Val : 3 count: 1 , Sum : 3 , i : 5 , minc : 1

 */
class MinSubArrayLen {
	
	
	
	
	public static int minSubArrayLen(int target, int[] nums) {

		int i = 0;
		int end = 1;
		int sum = nums[i];
		int count = 1, mincount = Integer.MAX_VALUE;
		if (sum == target) {
			return 1;
		}
		
		while (end < nums.length) {
			//System.out.print("Val : " + nums[end] );
			if (nums[end] == target) {
				mincount = 1;
				break;
			}

			else if (sum + nums[end] < target) {
				sum += nums[end];
				end++;
				count++;
			}

			else if (sum + nums[end] >= target) {
				if (sum + nums[end] == target && mincount > count +1) {
					mincount = count +1;
				}
				sum -= nums[i];
				i++;

				count--;
			}
			
			//.out.println( " count: " + count + " , Sum : " + sum + " , i : " +i + " , minc : " +mincount);

		}

		return mincount;
	}
	
	


	public static void main(String[] args) {
		//2,3,1,2,4,3
		System.out.println(minSubArrayLen(4, new int[] { 1,4,4 }));
		System.out.println(minSubArray(5, new int[] {2,4,6,8}));
	}
	
	public static int minSubArray (int target, int[] nums)
	{
		int sum = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int l = 0;
        for(int r = 0; r < n; r++){
            sum += nums[r];
            while (sum >= target){
                res = Math.min(res, r-l+1);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
	}
}