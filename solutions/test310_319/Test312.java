package test310_319;

public class Test312 {
    public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;

        // 创建左右端的虚拟气球
        int[] points = new int[nums.length + 2];
        points[0] = 1;
        points[nums.length+1] = 1;
        for(int i = 0; i < nums.length;i++){
            points[i+1] = nums[i];
        }

        int[][] dp = new int[points.length][points.length];
        for(int i = points.length-1; i >= 0 ; i --){
            for(int j = i+1; j < points.length; j++){
                for(int k = i + 1; k < j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i]*points[k]*points[j]);
                }
            }
        }

        return dp[0][points.length - 1];

    }
}