package test300_309;

import java.util.ArrayList;

public class Test300 {

    // 贪心 + 二分查找
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > list.get(list.size()-1))
                list.add(nums[i]);
            else{
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j) >= nums[i]){
                        list.set(j, nums[i]);
                        break;
                    }
                }
            }
        }

        return list.size();
    }  

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        Test300 test = new Test300();
        System.out.println(test.lengthOfLIS(nums));
    }
}