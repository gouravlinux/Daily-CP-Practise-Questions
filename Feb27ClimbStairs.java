class Solution {
    int[] dp;
    private int solve(int n){
        if (n == 0 || n == 1){//base case
            return 1;//only 1 way to reach at 1st or 0th stair
        }
        if (dp[n] != -1) return dp[n];
        dp[n] = solve(n-1) + solve(n-2);
        return dp[n];
    }
    public int climbStairs(int n) {
        // recursive+memoized solution
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
}
class Solution {
    int[] dp;
    public int climbStairs(int n) {
        // tabulation
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[n] represents no. of ways to reach nth stair
        // dp[n] = dp[n-1] + dp[n-2]
        for(int i = 2;i <= n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
