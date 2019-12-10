package test10_19;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * @author WOQUQ
 *
 */
public class Test16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(res == 0 || nums[i] - target > res/3) break;
        	
        	int j = i+1;
        	int k = nums.length - 1;
        	
        	while(j < k) {
        		int temp = target - (nums[i] + nums[j] + nums[k]);
        		if(res>Math.abs(temp)) {
        			res = Math.abs(temp);
        			ans = nums[i] + nums[j] + nums[k];
        		}
        		if(temp == 0) return ans;
        		if(temp > 0) j++;
        		else k--;
        	}
        	
        	
        }
        return ans;
    }
    public static void main(String[] args) {
		int[] nums = {0,2,1,-3};
		System.out.println(threeSumClosest(nums,1));
	}
}
