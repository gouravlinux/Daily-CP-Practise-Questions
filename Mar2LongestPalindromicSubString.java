class Solution {
    int n;

    private boolean solve(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return solve(s, i + 1, j - 1);
        } else {
            return false;
        }
    }

    public String longestPalindrome(String s) {
        int maxLen = 0;
        int sp = -1;
        n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (solve(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp + maxLen);
    }
}
class Solution {
    int n;
    Boolean[][] dp;

    private boolean solve(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (dp[i][j] != null)
            return dp[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(s, i + 1, j - 1);
        } else {
            return dp[i][j] = false;
        }
    }

    public String longestPalindrome(String s) {
        // using recursion + memoization
        int maxLen = 0;
        int sp = -1;
        n = s.length();
        dp = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (solve(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp + maxLen);
    }
}

