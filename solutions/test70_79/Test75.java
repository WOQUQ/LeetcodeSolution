package test70_79;

public class Test75 {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length-1;
        int p1 = 0;
        while(p1 <= p2) {
        	int temp = nums[p1];
        	if(temp == 0) {
        		int a = nums[p0];
        		nums[p0] = nums[p1];
        		nums[p1] = a;
        		p0++;
        		p1++;
        	}else if(temp == 2) {
        		int a = nums[p2];
        		nums[p2] = nums[p1];
        		nums[p1] = a;
        		p2--;
        	}else {
        		p1++;
        	}
        }
    }
    public static void main(String[] args) {
    	int[] nums = {2,0,2,1,1,0};
    	Test75 test = new Test75();
    	test.sortColors(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}
}
