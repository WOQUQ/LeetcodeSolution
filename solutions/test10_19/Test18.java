package test10_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

 * @author WOQUQ
 *
 */
public class Test18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 4) return res;
        
        for(int a = 0; a < nums.length-3; a++) {
        	if(a>0 && nums[a] == nums[a-1]) continue;
        	for(int b = a+1; b < nums.length-2; b++) {
        		if(b > a+1 && nums[b] == nums[b-1]) continue;
        		int m = b+1;
        		int n = nums.length - 1;
        		
        		while(m < n) {
        			if(nums[a] + nums[b] + nums[m] + nums[n] > target) n--;
        			else if(nums[a] + nums[b] + nums[m] +nums[n] < target) m++;
        			else {
        				if(m>b+1 && nums[m] == nums[m-1]) m++;
        				else if(n<nums.length-1 && nums[n] == nums[n+1]) n--;
        				else {
        					ArrayList<Integer> list = new ArrayList<Integer>();
        					list.add(nums[a]);
        					list.add(nums[b]);
        					list.add(nums[m]);
        					list.add(nums[n]);
        					res.add(list);
        					m++;
        					n--;
        				}
        			}
        		}
        	}
        	
        }
        return res;
    }
    public static void main(String[] args) {
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		System.out.println(fourSum(nums,0));
				
	}
}
