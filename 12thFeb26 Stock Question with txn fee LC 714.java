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
