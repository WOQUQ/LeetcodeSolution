package test40_49;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * @author WOQUQ
 *
 */
public class Test46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        boolean[] flag = new boolean[nums.length];
        helper(nums,new Stack<Integer>(),res,flag);
        return res;
    }
    
    private void helper(int[] nums,Stack<Integer> stack,List<List<Integer>> res,boolean[] flag){
    	if(stack.size() == nums.length) {
    		res.add(new ArrayList<Integer>(stack));
    		return;
    	}

    	for(int count = 0; count < nums.length; count++) {
    		if(!flag[count]) {
		    	stack.push(nums[count]);
		    	flag[count] = true;
		    	helper(nums,stack,res,flag);
		    	stack.pop();
		    	flag[count] = false;
    		}
    	}
    	
    }
    public static void main(String[] args) {
		Test46 test = new Test46();
		int[] nums = {1,2,3};
		List<List<Integer>> res = test.permute(nums);
		System.out.println(res);
	}
    
}
