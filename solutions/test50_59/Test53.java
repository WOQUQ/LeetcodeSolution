package test50_59;

public class Test53 {
	/** 动态规划法 **/
    public static int maxSubArray(int[] nums) {
    	if(nums.length == 0) return 0;
    	int max = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(temp > 0) temp += nums[i];
        	else temp = nums[i];
        	
        	if(temp > max) max = temp;
        }
        return max;
    }
    public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
