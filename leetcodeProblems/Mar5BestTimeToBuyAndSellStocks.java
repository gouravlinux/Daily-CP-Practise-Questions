class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int mini = prices[0];
        for(int i = 0;i<n;i++){
            int cost = prices[i] - mini;
            maxProfit = Math.max(cost, maxProfit);
            mini = Math.min(mini, prices[i]);// remembering the min(DP)
        }
        return maxProfit;
    }
}
