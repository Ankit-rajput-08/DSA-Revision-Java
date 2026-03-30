package array.two_pointers;


/*
Problem: Two Sum
Platform: LeetCode
Link: https://leetcode.com/problems/two-sum/

Description:
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

You can return the answer in any order.

-----------------------------------------------------

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

-----------------------------------------------------

Pattern:
Two Pointers / Brute Force
Two Pointers / Optimize


Approach:
1. Iterate through array using first loop
2. For each element, check next elements
3. If sum equals target, return indices
4. Since exactly one solution exists, return immediately

-----------------------------------------------------

Time Complexity:
O(n²)
O(n)

Space Complexity:
O(1)

-----------------------------------------------------

Edge Cases:
- negative numbers
- duplicate numbers
- target at start
- target at end
- small array size
*/


public class Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++ ){
            for(int j = i + 1; j < nums.length; j ++)
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
        }
        return new int[]{-1,-1};

    }

     public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;

        int i = 1;
        int j = n -1;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                return new int[] {i, j};
            }
            else if(numbers[i] + numbers[j] < target){
                i++;
            }
            else{
                j--;
            }
        }
        return new int[] {-1};
    }


}
