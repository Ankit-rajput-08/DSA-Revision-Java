package heap;

import java.util.*;

public class KFrequentWord {

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> map = new HashMap<>();

        for(String num : words){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Tair> pq = new PriorityQueue<>((a, b)->{

            if(a.second == b.second){

                return b.first.compareTo(a.first);

            }
            return  a.second - b.second;});


        for(Map.Entry<String,Integer> entry : map.entrySet()){
            Tair p = new Tair(entry.getKey(), entry.getValue());
            if(pq.size() < k) pq.offer(p);

            else if( p.second > pq.peek().second ||
                    (p.second == pq.peek().second &&
                            p.first.compareTo(pq.peek().first) < 0)){
                pq.poll();
                pq.offer(p);
            }
        }

        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().first);
        }
        Collections.reverse(ans);
        return ans;

    }
}


