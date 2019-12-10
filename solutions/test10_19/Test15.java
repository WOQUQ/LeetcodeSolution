package test10_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 * @author WOQUQ
 *
 */
public class Test15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] > 0) break; //如果检测到i数已大于0，则无需再进行其他操作，直接退出循环
        	if(i > 0 && nums[i] == nums[i-1]) continue;
        	//头尾双指针
        	int j = i+1;
        	int k = nums.length - 1;
        	
        	while(j < k) {
        		if(nums[i] + nums[j] + nums[k] > 0) k--;
        		else if(nums[i] + nums[j] +nums[k] < 0) j++;
        		else {
        			if(j>i+1 && nums[j] == nums[j-1]) j++;
        			else if( k+1<nums.length && nums[k] == nums[k+1]) k--;
        			else {
        				ArrayList<Integer> list = new ArrayList<Integer>();
        				list.add(nums[i]);
        				list.add(nums[j]);
        				list.add(nums[k]);
        				res.add(list);
        				k--;
        				j++;
        			}
        		}
        	}
        	
        }
        return res;
    }
    
    
    public static void main(String[] args) {
		int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		System.out.println(threeSum(nums));
	}
}
