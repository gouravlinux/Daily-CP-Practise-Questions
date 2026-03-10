class Solution {
    int m;
    int n;
    int N;
    Boolean[][][] dp;//O(m*n*N)

    private boolean solve(String s1, String s2, String s3, int i, int j, int k) {
        if (i == m && j == n && k == N)
            return true;
        if (k >= N)
            return false;//other string never consumed at all
        if (dp[i][j][k] != null) return dp[i][j][k];
        boolean result = false;
        if (i < m && s1.charAt(i) == s3.charAt(k))
            result = solve(s1, s2, s3, i + 1, j, k + 1);
        if (result == true)
            return dp[i][j][k] = result;
        if (j < n && s2.charAt(j) == s3.charAt(k))
            result = solve(s1, s2, s3, i, j + 1, k + 1);
        return dp[i][j][k] = result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // using recursion+memoization
        m = s1.length();
        n = s2.length();
        N = s3.length();
        dp = new Boolean[m+1][n+1][N+1];
        if (N != m+n)
            return false;
        return solve(s1, s2, s3, 0, 0, 0);
    }
}
class Solution {
    int m;
    int n;
    Boolean[][] dp;//O(m*n)

    private boolean solve(String s1, String s2, String s3, int i, int j) {
        if (i == m && j == n)
            return true;
        if (i+j >= s3.length())
            return false;//other string never consumed at all
        if (dp[i][j] != null) return dp[i][j];
        boolean result = false;
        if (i < m && s1.charAt(i) == s3.charAt(i+j))
            result = solve(s1, s2, s3, i + 1, j);
        if (result == true)
            return dp[i][j] = result;
        if (j < n && s2.charAt(j) == s3.charAt(i+j))
            result = solve(s1, s2, s3, i, j + 1);
        return dp[i][j] = result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // using recursion+memoization
        m = s1.length();
        n = s2.length();
        dp = new Boolean[m+1][n+1];
        if (m+n != s3.length()) return false;
        return solve(s1, s2, s3, 0, 0);
    }
}
class Solution {
    int m;
    int n;
    int N;
    Boolean[][] dp;//O(m*n)

    public boolean isInterleave(String s1, String s2, String s3) {
        // using tabulation
        m = s1.length();
        n = s2.length();
        N = s3.length();
        dp = new Boolean[m + 1][n + 1];
        //dp[i][j] = can strings interleave from lengths (i,j) to (m,n)
        if (m + n != N)
            return false;
        // base case: both strings exhausted
        dp[m][n] = true;
        // initialize last column(s2 exhausted, check s1 against s3)
        for (int i=m-1;i>=0;i--) {
            //check if at i & j chars are same and if from len i+1 to m can strings interleave
            dp[i][n] = (s1.charAt(i) == s3.charAt(i+n)) && dp[i+1][n];
        }
        for (int j = n-1;j>=0;j--) {
            dp[m][j] = (s2.charAt(j) == s3.charAt(m+j)) && dp[m][j+1];
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + j >= N)
                    dp[i][j] = false;//other string never consumed at all
                boolean result = false;
                if (s1.charAt(i) == s3.charAt(i + j))
                    result = dp[i + 1][j];
                if (result == true) {
                    dp[i][j] = result;
                    continue;
                }
                if (s2.charAt(j) == s3.charAt(i + j))
                    result = dp[i][j + 1];
                dp[i][j] = result;
            }
        }
        return dp[0][0];
    }

}
class Solution {
    int m;
    int n;
    int N;
    Boolean[][] dp;//O(m*n)

    public boolean isInterleave(String s1, String s2, String s3) {
        // using tabulation
        m = s1.length();
        n = s2.length();
        N = s3.length();
        dp = new Boolean[m + 1][n + 1];
        if (m + n != N)
            return false;
        dp[0][0] = true;
        //dp[i][j] till length (i,j) are strings interleaving?
        for (int i = 1; i <= m; i++) {
            dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[i - 1][0];
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = (s2.charAt(j - 1) == s3.charAt(j - 1)) && dp[0][j - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = false;
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j];//i-1,j tak to interleaving 
                }
                if (dp[i][j] == true)
                    continue;
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1];//i,j-1 tak to interleaving
                }
            }
        }
        return dp[m][n];
    }

}
