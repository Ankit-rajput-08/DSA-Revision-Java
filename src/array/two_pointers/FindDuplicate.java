package array.two_pointers;

import java.util.Arrays;

/*

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3


Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
public class FindDuplicate {

    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int findDuplicate(int[] nums) {

        //brut force
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length -1; i++){
//            if(nums[i] == nums[i + 1]){
//                return nums[i];
//            }
//        }
//        return -1;

        //optimal

        while(nums[0] != nums[nums[0]]){
            swap(nums, 0,nums[0]);
        }
        return nums[0];
    }
    public static void main(String [] args){
        FindDuplicate obj = new FindDuplicate();
        int[] arr = {1,3,4,2,2};
        int res = obj.findDuplicate(arr);
        System.out.print(res);

    }
}




