class Solution {
    int n;
    int[][] dp;
    private int solve(int[] prices, int fee, int day, int buy) {
        if (day >= n)
            return 0;
        if (dp[day][buy] != -1) return dp[day][buy];
        int profit = 0;
        if (buy == 1) {
            // I only can buy (not sell)
            // buy on day
            int buyProfit = -prices[day] + solve(prices, fee, day + 1, 0);//as I can sell only next day
            // not buy on that day
            int notBuyProfit = solve(prices, fee, day + 1, 1);//you need to buy next day
            profit = Math.max(profit, Math.max(buyProfit, notBuyProfit));
        } else {
            // I can sell only
            // if sold today
            int sellProfit = prices[day] + solve(prices, fee, day + 1, 1) - fee;// next day buy
            int notSellProfit = solve(prices, fee, day + 1, 0);//only sell next day
            profit = Math.max(profit, Math.max(sellProfit, notSellProfit));
        }
        return dp[day][buy] = profit;
    }

    public int maxProfit(int[] prices, int fee) {
        // using recursion + memoization
        n = prices.length;
        int buy = 1;//like a boolean (for recur+memo)
        dp = new int[n][2];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(prices, fee, 0, buy);
    }
}
class Solution {
    public int maxProfit(int[] prices, int fee) {
        // tabulation 
        int n = prices.length;
        int[][] dp = new int[n][2];
        // dp[day][0/1] = at that day I either buy or sell stock to get maxProfit
       
        
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i < n;i++){
            // dp[day][0] = I not buy or sell the existing stock
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
            // dp[day][1] = I buy or hold the existing stock
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]); 
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
