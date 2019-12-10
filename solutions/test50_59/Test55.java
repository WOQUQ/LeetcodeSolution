package test50_59;

public class Test55 {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        if(size < 2) return true;
        int lastGood = size-1;

        for(int i = size-2; i >= 0;i--) {
        	if(i + nums[i] >= lastGood) {
        		lastGood = i;
        	}
        }
        
        if(lastGood == 0) return true;
        return false;
    }
}
