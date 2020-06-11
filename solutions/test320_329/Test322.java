package test320_329;
/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 */

import java.util.HashMap;

public class Test322 {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

    // 方法一 自顶向下 记忆化递归 
    public int coinChange(int[] coins, int amount) {
        if( coins.length == 0) return -1;
        if(amount == 0) return 0;
        return helper(coins, amount);
    }

    private int helper(int[] coins, int curr){
        if(map.containsKey(curr)) return map.get(curr);
        // boolean canBePaid = false;
        int temp = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin == curr){
                map.put(curr, 1);
                return 1;
            }

            if(curr > coin){
                int pre = helper(coins,curr-coin);
                if(pre == -1) continue;
                temp = Math.min(temp,pre);

                
            }
        }
        int res = temp != Integer.MAX_VALUE ? temp + 1 : -1;
        map.put(curr, res);
        return res;

    }

    // 方法二 自底向上 DP
    public int coinChange2(int[] coins, int amount) {
        if( coins.length == 0) return -1;
        if(amount == 0) return 0;

        int[] dp = new int[amount+1];
        for(int i = 1; i < amount + 1; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int coin : coins){

                // 如果刚好为货币面值，直接记为1
                if(i == coin){
                    dp[i] = 1;
                    break;
                }

                if(i - coin > 0){
                    if(dp[i-coin] == -1){
                        continue;
                    }

                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }

            }
            if(dp[i] == Integer.MAX_VALUE) dp[i] = -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Test322 test = new Test322();
        int[] coins = {1,2,5};
        System.out.println(test.coinChange2(coins, 11));
    }
}