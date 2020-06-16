package test340_349;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Test347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(k);
        for(int num : nums){
                map.put(num,map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> map.get(n1) - map.get(n2));
        for(int frequent : map.keySet()){
            heap.add(frequent);
            if(heap.size() > k){
                heap.poll();
            }
        }
        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }

        return res;
    }
}