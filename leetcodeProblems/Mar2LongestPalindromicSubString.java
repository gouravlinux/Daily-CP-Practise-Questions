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
class Solution {
    public String longestPalindrome(String s) {//O(n^2)
        //using tabulation
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        int maxLen = 1;
        int sp = -1;
        // for length = 1; always true and palindrome        
        for(int i = 0;i < n;i++){
            dp[i][i] = true;
            sp = i;
        }
        // for lengths >= 2;
        for(int L = 2;L<=n;L++){
            for(int i = 0;i+L-1<n;i++){
                int j = i+L-1;//therefore in for loop condition j<n
                // if length == 2
                if (i+1 == j && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    maxLen = 2;
                    sp = i;
                }
                // if length > 2
                else if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if (j-i+1>maxLen){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
                else{
                    // not a palindrome
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(sp, sp+maxLen);
    }
}
