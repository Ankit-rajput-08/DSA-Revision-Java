package array.two_pointers;

/*
Given an array arr consisting of only 0's and 1's in random order. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.


Examples :

Input: arr[] = [0, 0, 1, 1, 0]
Output: [0, 0, 0, 1, 1]
Explanation:  After segregation, all the 0's are on the left and 1's are on the right. Modified array will be [0, 0, 0, 1, 1].
Input: arr[] = [1, 1, 1, 1]
Output: [1, 1, 1, 1]
Explanation: There are no 0s in the given array, so the modified array is [1, 1, 1, 1]
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
        1 ≤ arr.size() ≤ 106
        0 ≤ arr[i] ≤ 1



Approach:
We use two pointers:

i → start of array
j → end of array

If arr[i] is 0 → move forward
If arr[j] is 1 → move backward
If arr[i] is 1 and arr[j] is 0 → swap

This ensures all 0s move to left and 1s move to right.

Time Complexity: O(n)
Space Complexity: O(1)

*/
public class GfgSegregate0and1 {
    void segregate0and1(int[] arr) {
        // code here
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            if(arr[i] == 0) i++;
            if(arr[j] == 1) j--;
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
