package array.two_pointers;

/*

Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).


Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104

 */

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int total = nums[i] + nums[left] + nums[right];
                int d = Math.abs(target - total);

                if(d < diff) {
                    diff = d;
                    res = total;
                }
                if(total == target) return res;
                if(total < target) left++;
                else right--;
            }
        }
        return res;
    }

    public static void main(String [] args){
        ThreeSumClosest obj = new ThreeSumClosest();
        int[] arr = {-1,2,1,-4};
        int target = 1;
        System.out.println(obj.threeSumClosest(arr,target));
    }
}
