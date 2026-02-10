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
