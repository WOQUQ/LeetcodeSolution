package test120_129;

import java.util.HashSet;

class Test128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }

        int result = 0;
        for(int num : nums){
            if(!set.contains(num - 1)){

                int temp = 1;
                while(set.contains(num + 1)){
                    num++;
                    temp++;
                }

                if(temp > result) result = temp;
            }
        }
        return result;
    }
}