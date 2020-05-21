package test190_199;

public class Test198 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;

        int max1 = 0;
        int max2 = 0;
        for(int num : nums){
            int temp = max1;
            max1 = max2;
            max2 = Math.max(temp + num, max2);
        }

        return max2;
    }
}