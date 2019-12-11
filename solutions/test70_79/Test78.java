package test70_79;

import java.util.ArrayList;
import java.util.List;

public class Test78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> empty = new ArrayList<>();
        res.add(empty);
        if(nums.length == 0) {
        	return res;
        }
        
    	addNewList(0,nums,empty,res);
    	
    	return res;
    }
    
    public void addNewList(int newIndex,int[] nums, List<Integer> curr,List<List<Integer>> res) {
    	if(newIndex >= nums.length) return;
    	
    	//don't add the new value
    	addNewList(newIndex+1,nums,curr,res);
    	
    	//add the new value
    	ArrayList<Integer> list = new ArrayList<>();
    	list.addAll(curr);
    	list.add(nums[newIndex]);
    	res.add(list);
    	addNewList(newIndex+1,nums,list,res);
    	
    }
    public static void main(String[] args) {
		int[] nums = {1,2,3};
		Test78 test = new Test78();
		System.out.println(test.subsets(nums));
	}
    
}
