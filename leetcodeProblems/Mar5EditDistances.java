class Solution {
    int m;
    int n;
    int[][] dp;
    private int solve(String word1, String word2, int i,int j){
        if (j == n) return m-i;//delete m-i chars 
        if (i == m) return n-j;//insert n-j chars
        if (dp[i][j] != -1) 
            return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) 
            return dp[i][j] = solve(word1,word2,i+1,j+1);
        int insert = 1 + solve(word1,word2,i,j+1);
        int delete = 1 + solve(word1,word2,i+1,j);
        int replace = 1 + solve(word1,word2,i+1,j+1);
        return dp[i][j] = Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        // recursion + memoization
        m = word1.length();
        n = word2.length();
        dp = new int[m][n];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return solve(word1, word2, 0, 0);
    }
}
class Solution {
    int m;
    int n;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        // tabulation
        m = word1.length();
        n = word2.length();
        dp = new int[m+1][n+1];
        // dp[i][j] till lens i,j in words, min. operations required to get 
        // them same
        for(int row = 0;row<=m;row++){
            dp[row][0] = row;
        }
        for(int col = 0;col<=n;col++){
            dp[0][col] = col;
        }
        for(int row = 1;row<=m;row++){
            for(int col = 1;col<=n;col++){
                if(word1.charAt(row-1) == word2.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1];
                }
                else{
                    int insert = 1 + dp[row][col-1];
                    int replace = 1 + dp[row-1][col-1];
                    int delete = 1 + dp[row-1][col];
                    dp[row][col] = Math.min(insert,Math.min(replace,delete));
                }
            }
        }
        return dp[m][n];
    }
}
