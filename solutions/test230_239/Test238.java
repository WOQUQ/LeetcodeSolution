package test230_239;

class Test238{
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if(length <= 1) return nums;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        for(int i = 1; i < length; i++){
            left[i] = left[i-1] * nums[i-1];
            right[length-1-i] = right[length-i] * nums[length-i];
        } 

        int[] result = new int[length];
        for(int i =0; i < length; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Test238 test = new Test238();
        int[] res = test.productExceptSelf(nums);
        for(int r : res){
            System.out.println(r);
        }
    }
}