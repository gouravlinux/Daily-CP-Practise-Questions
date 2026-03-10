class Solution {
    int n;
    int[][] dp;
    private int solve(int[] prices, int day,int buy){
        if (day >= n)
            return 0;//base case
        int profit = 0;
        if (dp[day][buy] != -1)
            return dp[day][buy];
        if (buy == 1){
            // buy stock on day and sell it on next day
            int iBuyStock = -prices[day]+solve(prices, day+1, 0);
            
            int iNotBuyStock = solve(prices, day+1, 1);
            //can buy on next day
            profit = Math.max(iBuyStock, iNotBuyStock);
        }
        else{//buy is false which means sell is true
            // sell stock on day and it adds up to profit made after 2 days
            int iSellStock = prices[day] + solve(prices, day+2, 1);
            // not sell stock
            int iNotSellStock = solve(prices, day+1, 0);
            profit = Math.max(iSellStock, iNotSellStock);
        }
        return dp[day][buy] = profit;
    }
    public int maxProfit(int[] prices) {
	// recursion + memoization
        int buy = 1;
        n = prices.length;
        dp = new int[n][2];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return solve(prices, 0, buy);        
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        
        // tabulation method
        int n = prices.length;
        if (n == 1)
            return 0;
        int[] dp = new int[n];
        // dp[i] -> the max total profit until day i
        dp[0] = 0;//no profit as on 0th day I can only buy a stock
        dp[1] = Math.max(prices[1] - prices[0], 0);
        for(int i = 2;i < n;i++){
            dp[i] = dp[i-1];
            for(int j = 0;j < i;j++){
                // find best j to buy the stock before selling it on ith day
                int prev_profit = j>=2?dp[j-2]:0;
                dp[i] = Math.max(dp[i], prices[i] - prices[j] + prev_profit);
            }
        }
        return dp[n-1];
    }
}
