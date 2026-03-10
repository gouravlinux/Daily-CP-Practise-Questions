class Solution {
    int n;
    int[][][] dp;

    private int solve(int[] prices, int idx, int willBuy, int txnsLeft) {
        if (txnsLeft == 0 || idx >= n)
            return 0;
        if (dp[idx][willBuy][txnsLeft] != -1)
            return dp[idx][willBuy][txnsLeft];
        int maxProfit;
        if (willBuy == 1) {
            // can buy
            int buyThatDay = -prices[idx] + solve(prices, idx + 1, 0, txnsLeft);
            int notBuyThatDay = 0 + solve(prices, idx + 1, 1, txnsLeft);
            maxProfit = Math.max(buyThatDay, notBuyThatDay);
        } else {
            //can't buy
            int sellThatDay = prices[idx] + solve(prices, idx + 1, 1, txnsLeft - 1);
            int notSellThatDay = 0 + solve(prices, idx + 1, 0, txnsLeft);
            maxProfit = Math.max(sellThatDay, notSellThatDay);
        }
        return dp[idx][willBuy][txnsLeft] = maxProfit;
    }

    public int maxProfit(int[] prices) {
        // recursion+memoization
        n = prices.length;
        dp = new int[n][2][3];//as txnsLeft has 3 states:0,1,2
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return solve(prices, 0, 1, 2);
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        // using tabulation (copy of recursion)
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        // no need of base cases: already values are 0
        // for(int i = 0;i<n;i++){
        //     for(int buy = 0;buy<2;buy++){
        //         dp[i][buy][0] = 0;//first base case
        //     }
        // }
        // for(int buy = 0;buy<2;buy++){
        //     for(int cap = 0;cap<3;cap++){
        //         dp[n][buy][cap] = 0;//second base case
        //     }
        // }
        for(int idx = n-1;idx>=0;idx--){
            for(int buy = 1;buy>=0;buy--){
                for(int cap = 2;cap>0;cap--){
                    if (buy == 1){
                        dp[idx][buy][cap] = Math.max(-prices[idx]+dp[idx+1][0][cap],dp[idx+1][1][cap]);
                    }
                    else{
                        dp[idx][buy][cap] = Math.max(prices[idx]+dp[idx+1][1][cap-1],dp[idx+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        // using tabulation (copy of recursion) + space-optimized
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];
        // no base cases needed: already every element is 0
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int cap = 2; cap > 0; cap--) {
                    if (buy == 1) {
                        curr[buy][cap] = Math.max(-prices[idx] + after[0][cap], after[1][cap]);
                    } else {
                        curr[buy][cap] = Math.max(prices[idx] + after[1][cap - 1], after[0][cap]);
                    }
                }
            }
            after = curr;
        }
        return curr[1][2];
    }
}
class Solution {
    int n;
    int[][] dp;
    private int solve(int[] prices,int idx,int txnNo){
        if (idx == n || txnNo == 4) return 0;
        if (dp[idx][txnNo] != -1) return dp[idx][txnNo];
        if (txnNo%2 == 0){
            // can buy
            return dp[idx][txnNo] = Math.max(-prices[idx]+solve(prices,idx+1,txnNo+1),solve(prices,idx+1,txnNo));
        }
        else{
            // can't buy
            return dp[idx][txnNo]=Math.max(prices[idx]+solve(prices,idx+1,txnNo+1),solve(prices,idx+1,txnNo));
        }
    }
    public int maxProfit(int[] prices) {
        // (using recursion + memoization)->txns are noed(only 4 can be done)
        n = prices.length;
        dp = new int[n][4];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return solve(prices,0, 0);
    }
}
class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        // (using tabulations)->txns are noed(only 4 can be done)
        n = prices.length;
        dp = new int[n+1][5];
        for(int idx = n-1;idx>=0;idx--){
            for(int txnNo = 3;txnNo>=0;txnNo--){
                if (txnNo%2 == 0){
                // can buy
                dp[idx][txnNo] = Math.max(-prices[idx]+dp[idx+1][txnNo+1],dp[idx+1][txnNo]);
        }
            else{
                // can't buy
                dp[idx][txnNo] = Math.max(prices[idx]+dp[idx+1][txnNo+1],dp[idx+1][txnNo]);
            }
            }
        }
        return dp[0][0];
    }
}
class Solution {
    int n;
    int[] curr;
    int[] ahead;
    public int maxProfit(int[] prices) {
        // (using tabulations)->txns are noed(only 4 can be done)->space optimized
        n = prices.length;
        ahead = new int[5];
        curr = new int[5];
        for(int idx = n-1;idx>=0;idx--){
            for(int txnNo = 3;txnNo>=0;txnNo--){
                if (txnNo%2 == 0){
                    // can buy
                    curr[txnNo] = Math.max(-prices[idx]+ahead[txnNo+1],ahead[txnNo]);
                }
                else{
                    // can't buy
                    curr[txnNo] = Math.max(prices[idx]+ahead[txnNo+1],ahead[txnNo]);
                }
            }
            ahead = curr;
        }
        return curr[0];
    }
}

