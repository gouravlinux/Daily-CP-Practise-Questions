class Solution {
    int n;
    int[][] dp;
    private int solve(int[] val, int[] wt, int idx, int rc){
        // rc -> remainingCapacity
        if (idx >= n) return 0;
        if (rc <= 0) return 0;
        if (dp[idx][rc] != -1) return dp[idx][rc];
        int inclusionProfit = 0;
        if (rc >= wt[idx]){
            inclusionProfit = val[idx] + 
            solve(val, wt, idx+1, rc-wt[idx]);
        }
        int exclusionProfit = solve(val, wt, idx+1, rc);
        return dp[idx][rc] = Math.max(inclusionProfit, exclusionProfit);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        // using recursion+memoization
        n = val.length;
        dp = new int[n+1][W+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(val, wt, 0, W);
    }
}
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        // bottom-up approach
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        // dp[i][j] represents max Profit found from index i to last
        // and rc = j
        
        //last item to last index is 0 profit
        for(int j = 0;j <= W;j++) dp[n][j] = 0;
        // no item can be included if rc = 0
        for(int i = 0;i <= n;i++) dp[i][0] = 0;
        for(int i = n-1;i>=0;i--){
            for(int j = W;j>0;j--){
                int inclusionProfit = 0;
                if (j >= wt[i]){
                    // if rc >= wt of currect item
                    inclusionProfit = val[i] + dp[i+1][j-wt[i]];
                }
                int exclusionProfit = dp[i+1][j];
                dp[i][j] = Math.max(inclusionProfit, exclusionProfit);
            }
        }
        
        return dp[0][W];
    }
}

