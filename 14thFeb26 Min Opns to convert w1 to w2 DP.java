class Solution {
    int m;
    int n;
    int[][] dp;
    private int solve(String word1, String word2, int i,int j){
        if (i == m) return n-j;//n-j insertions would be required
        if (j == n) return m-i;// m-i deletions would be required
        if (word1.charAt(i) == word2.charAt(j)) return solve(word1,word2,i+1,j+1);
        if (dp[i][j] != -1) return dp[i][j];
        int insert = 1 + solve(word1, word2, i, j+1);
        int delete = 1 + solve(word1, word2, i+1, j);
        int replace = 1 + solve(word1, word2, i+1, j+1);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        // using recursion + memoization
        m = word1.length();
        n = word2.length();
        dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(word1, word2, 0, 0);
    }
}
class Solution {
    int m;
    int n;
    int[][] dp;
    private int solve(String word1, String word2, int i,int j){
        // here now i & j is left chars in string 
        if (i == 0) return j;//j insertions would be required
        if (j == 0) return i;//i deletions would be required
        if (word1.charAt(i-1) == word2.charAt(j-1)) return solve(word1,word2,i-1,j-1);
        if (dp[i][j] != -1) return dp[i][j];
        int insert = 1 + solve(word1, word2, i, j-1);
        int delete = 1 + solve(word1, word2, i-1, j);
        int replace = 1 + solve(word1, word2, i-1, j-1);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        // using recursion + memoization from end to start
        m = word1.length();
        n = word2.length();
        dp = new int[m+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(word1, word2, m, n);
    }
}
class Solution {
    public int minDistance(String word1, String word2) {
        // bottom-up: reverse way
        // dp[i][j] represents min no of operations to convert w1[i->m] to w2[j->n]
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int j = 0;j <= n;j++) dp[m][j] = n-j;// insertions 
        for(int i = 0;i <= m;i++) dp[i][n] = m-i;// deletions
        for(int i = m-1;i >= 0;i--){
            for(int j = n-1;j >= 0;j--){
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1];
                }
                else{
                    int insert = 1 + dp[i][j+1];
                    int delete = 1 + dp[i+1][j];
                    int replace = 1 + dp[i+1][j+1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                } 
            }
        }
        return dp[0][0];
    }
}
class Solution {
    public int minDistance(String word1, String word2) {
        // bottom-up:
        // dp[i][j] represents min no of operations to convert w1 of len i to w2 of len j
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int j = 0;j <= n;j++) dp[0][j] = j;// no of insertions 
        for(int i = 0;i <= m;i++) dp[i][0] = i;// no of deletions
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                } 
            }
        }
        return dp[m][n];
    }
}
