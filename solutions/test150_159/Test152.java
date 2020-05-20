package test150_159;

class Test152{
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];

        int result = nums[0];

        int currMax = nums[0];
        int currMin = nums[0];

        for(int i = 1; i < nums.length; i++){
            int tempMax = currMax;
            int tempMin = currMin;
            currMax = Math.max(Math.max(tempMax * nums[i],tempMin * nums[i]),nums[i]);
            currMin = Math.min(Math.min(tempMax * nums[i],tempMin * nums[i]),nums[i]);
            if(currMax > result){
                result = currMax;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Test152 test = new Test152();
        int[] nums = {-4,-3,-2};
        System.out.println(test.maxProduct(nums));
    }
}