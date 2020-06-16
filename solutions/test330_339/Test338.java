package test330_339;

public class Test338 {
    public int[] countBits(int num) {
        if(num == 0) return new int[1];
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= num; i++){
            dp[i] = i % 2 == 1 ? dp[i-1] + 1 : dp[i/2];
        }
        return dp;
    }
}