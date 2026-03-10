class Solution {
    int n;
    int m;
    int[][] dp;

    private int solve(String text1, String text2, int i, int j) {
        if (i >= n || j >= m)
            return 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + solve(text1, text2, i + 1, j + 1);
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        int include_i = solve(text1, text2, i, j + 1);
        int include_j = solve(text1, text2, i + 1, j);
        return dp[i][j] = Math.max(include_i, include_j);
    }

    public int longestCommonSubsequence(String text1, String text2) {

        // recursion + memoization
        n = text1.length();
        m = text2.length();
        dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return solve(text1, text2, 0, 0);
    }
}
class Solution {
    int m;
    int n;
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        dp = new int[m + 1][n + 1];
        // tabulation (bottom-up DP)
        // dp[i][j] = LCS of length i in text1 and length j in text2
        // dp[0][i] = 0 and dp[i][0] = 0 (as nothing could be common)
        // below lines are obvious in java
        // for(int j = 0;j <= m;j++){
        //     dp[0][j] = 0;
        // }
        // for(int i = 0;i <= n;i++){
        //     dp[i][0] = 0;
        // }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    // 1 + value of any LCS found till i-1,j-1
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
