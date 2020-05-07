package test120_129;

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int minCurr = prices[0];
        int result = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - minCurr > result) result = prices[i] - minCurr;
            if(prices[i] < minCurr) minCurr = prices[i];
        }

        return result;
    }
}