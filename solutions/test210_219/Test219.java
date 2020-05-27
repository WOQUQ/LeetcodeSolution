package test210_219;

import java.util.PriorityQueue;

public class Test219 {
    // TOP-K

    // 方法一 - 小顶堆
    public int findKthLargest1(int[] nums, int k) {
        //小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        for(int num : nums){
            queue.add(num);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();

    }
    
    // 方法二 - 快速选择（基于快速排序）
    public int findKthLargest2(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        if(left == right) return nums[0];
        return quickSelect(nums, k, left, right);
    }

    private int quickSelect(int[] nums,int k, int left,int right){
        int medium = nums[left];

        while(left < right){

            while(nums[right] <= medium && left < right){
                --right;
            }
            nums[left] = nums[right];

            while(nums[left] >= medium && left < right){
                ++left;
            }

            nums[right] = nums[left];
        }
        nums[left] = medium; 

        // check the position of the medium
        if(left+1 == k)
            return nums[left];
        else if (left+1 < k)
            return quickSelect(nums, k, left+1, nums.length-1);
        else
            return quickSelect(nums, k, 0, left-1);
    }

    // 方法三 - BFPRT算法 中位数的中位数算法 （在方法二基础上的改进,主要是medium的选择问题）
    public int findKthLargest3(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        if(left == right) return nums[0];
        return bfprt(nums, k, left, right);
    }

    private int bfprt(int[] nums,int k, int left, int right){
        int begin = left;
        int end = right;
        int mediumIndex = getMedium(nums,left,right);
        int medium = nums[mediumIndex];
        swap(nums,left,mediumIndex);

        while(left < right){

            while(nums[right] <= medium && left < right){
                --right;
            }
            nums[left] = nums[right];

            while(nums[left] >= medium && left < right){
                ++left;
            }

            nums[right] = nums[left];
        }
        nums[left] = medium;

        // check the position of the medium
        if(left+1 == k)
            return nums[left];
        else if (left+1 < k)
            return bfprt(nums, k, left+1, end);
        else
            return bfprt(nums, k, begin, left-1);
    }

    private int getMedium(int[] nums, int left, int right){
        if(left == right) return left;
        
        int positionToSwap = left;
        int i = left;
        for( ; i <= right -5; i += 5){
            insertSort(nums, i, i+4);
            swap(nums, positionToSwap, i+2);
            positionToSwap++;
        }

        insertSort(nums, i, right);
        swap(nums, positionToSwap, i + (right - i)/2);
        return getMedium(nums, left, positionToSwap);
    }
    
    // 插入排序 - 倒序
    private void insertSort(int[] nums,int left, int right){
        for(int i = left+1; i <= right; i++){
            if(nums[i] > nums[i-1]){
                int temp = nums[i];

                int j = i-1;
                for(; j >= left; j--){
                    if(nums[j] < temp)
                        nums[j+1] = nums[j];  
                    else
                        break;
                }
                nums[j+1] = temp;
            }
        }
    }

    private void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    // test{
    public static void main(String[] args) {
        Test219 test = new Test219();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(test.findKthLargest3(nums, k));
        // test.insertSort(nums, 0, nums.length-1);
        // for(int num : nums){
        //     System.out.println(num);
        // }
        // System.out.println(test.getMedium(nums, 1, 8));
    }
}