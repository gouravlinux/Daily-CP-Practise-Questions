class Solution {
    int n;
    int[] dp;

    private int solve(int[] coins, int amount) {
        // base case
        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (dp[amount] != -1)
            return dp[amount];
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int calcRest = solve(coins, amount - coins[i]);
            if (calcRest != Integer.MAX_VALUE)
                cnt = Math.min(1+calcRest, cnt);// 1 added to get that coin
        }
        return dp[amount] = cnt;
    }

    public int coinChange(int[] coins, int amount) {
        // using recursion + memoization
        n = coins.length;
        dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int ans = solve(coins,amount);
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        // using tabulation
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;//to get 0, we need 0 coins
        for (int i = 1; i <= amount; i++) {
            for (int val : coins) {
                int remAmt = i - val;
                // done to prevent integer overflow check if 
                // dp[remAmt] != Infinity
                if (remAmt >= 0 && dp[remAmt] != Integer.MAX_VALUE) {
                    //becoz -ve value should not be considered
                    dp[i] = Math.min(1 + dp[remAmt], dp[i]);
                    
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
