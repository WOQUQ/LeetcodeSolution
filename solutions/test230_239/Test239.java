package test230_239;

import java.util.ArrayDeque;

public class Test239 {
    // 方法一 双向队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length * k == 0) return null;
        if(k == 1) return nums;

        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(k);

        // init
        for(int i = 0; i < k; i++){
            while( !deque.isEmpty() && nums[i] > nums[deque.getLast()] ){
                deque.pollLast();
            }
            deque.addLast(i);
        }

        int[] res = new int[length - k + 1];
        res[0] = nums[deque.getFirst()];


        for(int i = k; i < length; i++){
            while(!deque.isEmpty() && deque.getFirst() <= i-k){
                deque.pollFirst();
            }
            while( !deque.isEmpty() && nums[i] > nums[deque.getLast()] ){
                deque.pollLast();
            }
            deque.addLast(i);
            res[i-k+1] = nums[deque.getFirst()];

        }


        return res;

    } 
      

    // 方法二 动态规划
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int length = nums.length;
        if(length * k == 0) return null;
        if(k == 1) return nums;

        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = nums[0];
        right[length - 1] = nums[length - 1];
        for(int i = 1; i < length; i++){
            left[i] = i % k == 0 ? nums[i] : Math.max(left[i - 1], nums[i]);
            right[length - 1 - i] = (length-i) % k == 0 ? nums[length - 1 - i] : Math.max(right[length - i], nums[length - 1 - i]);
        }

        int[] result = new int[length- k + 1];
        for(int i = 0; i < length - k + 1; i++){
            result[i] = Math.max(left[i + k - 1], right[i]);
        }

        return result;
    } 

    public static void main(String[] args) {
        Test239 test = new Test239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = test.maxSlidingWindow2(nums, 3);
        for(int r : res){
            System.out.println(r);
        }

    }
}