package array.two_pointers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.


Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class SortedSquare {

    public int[] sortedSquares(int[] nums) {
        // for(int i = 0; i < nums.length; i++){
        //     nums[i] = nums[i] * nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;

        int n = nums.length;
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // Separate negative and positive numbers
        for (int num : nums) {
            if (num < 0)
                neg.add(num);
            else
                pos.add(num);
        }

        // Case 1: No negative numbers
        if (neg.size() == 0) {
            for (int i = 0; i < pos.size(); i++)
                pos.set(i, pos.get(i) * pos.get(i));
            return pos.stream().mapToInt(Integer::intValue).toArray();
        }

        // Case 2: No positive numbers
        if (pos.size() == 0) {
            for (int i = 0; i < neg.size(); i++)
                neg.set(i, neg.get(i) * neg.get(i));
            Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray();
        }

        // Case 3: Both negative and positive exist
        int i = 0, j = 0, id = 0;
        int n1 = neg.size();
        int n2 = pos.size();
        int[] res = new int[n1 + n2];

        // Square negatives and reverse them
        for (i = 0; i < n1; i++)
            neg.set(i, neg.get(i) * neg.get(i));
        Collections.reverse(neg);

        // Square positives
        for (i = 0; i < n2; i++)
            pos.set(i, pos.get(i) * pos.get(i));


        i = 0;
        j=0;
        while (i < n1 && j < n2) {
            if (neg.get(i) <= pos.get(j)) {
                res[id++] = neg.get(i++);

            } else {
                res[id++] = pos.get(j++);
            }
        }

        while (i < n1)
            res[id++] = neg.get(i++);

        while (j < n2)
            res[id++] = pos.get(j++);

        return res;
    }
    public static void main(String[] args) {

        SortedSquare obj = new SortedSquare();

        int[] nums = {-4,-1,0,3,10};

        int[] res = obj.sortedSquares(nums);

        for(int i : res)
            System.out.print(i + " ");
    }
}
