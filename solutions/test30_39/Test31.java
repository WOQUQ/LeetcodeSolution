package test30_39;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * @author WOQUQ
 *基本思路：若是严格降序数组，则翻转后输出；从后往前找到第一个比后数小的数，将其与右侧最小的大于它的数交换位置，接着将右侧数组翻转
 */
public class Test31 {
    public static void nextPermutation(int[] nums) {
    	int m = -1;
        for(int i = nums.length-2; i >=0 ; i--) {
        	if(nums[i] < nums[i+1]) {
        		m = i;
        		break;
        	}
        }
        if(m == -1) {
        	reverse(nums,0,nums.length - 1);
        	return;
        }
        int temp = Integer.MAX_VALUE;
        int n = 0;
        for(int i = m+1; i < nums.length ; i++) {
        	if(nums[i] > nums[m] && nums[i] - nums[m] < temp) {
        		n = i;
        	}
        }
        
        temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
        
        reverse(nums,m+1,nums.length - 1);
        System.out.println(nums);
        
    }
    private static void reverse(int[] nums, int begin,int end) {
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i  = begin; i <= end; i++) {
    		stack.push(nums[i]);
    	}
    	for(int i = begin; i <= end ; i++) {
    		nums[i] = stack.pop();
    	}
    }
    
    public static void main(String[] args) {
		int[] nums = {1,2,3};
		nextPermutation(nums);
	}
}
