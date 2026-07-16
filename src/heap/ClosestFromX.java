package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]



Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
 */
public class ClosestFromX {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Chair> pq = new PriorityQueue<>((a, b) -> {
            if(a.distance == b.distance) return b.y - a.y;
            return b.distance - a.distance;
        });

        for(int num : arr){

            int distance = Math.abs(num - x);
            Chair p = new Chair(distance,num);

            if(pq.size() < k) pq.offer(p);
            else if(distance < pq.peek().distance || (distance == pq.peek().distance && num < pq.peek().y)){
                pq.poll();
                pq.offer(p);
            }

        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            Chair p = pq.poll();
            ans.add(p.y);
        }
        Collections.sort(ans);
        return ans;
    }
}
