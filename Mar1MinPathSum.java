class Solution {
    int m;
    int n;
    int[][] dp;
    private int solve(int[][] grid, int i, int j) {//O(m*n)
        //base case: can't reach to destination
        if (i >= m || j >= n)
            return Integer.MAX_VALUE;
        if (i == m-1 && j == n-1) return grid[i][j];// reached successfully!
        if (dp[i][j] != -1) return dp[i][j];
        int downVal = solve(grid, i + 1, j);
        int rightVal = solve(grid, i, j + 1);
        int minVal = Math.min(downVal, rightVal);
        if (minVal != Integer.MAX_VALUE)
            minVal += grid[i][j];
        return dp[i][j] = minVal;
    }

    public int minPathSum(int[][] grid) {
        // recursion + memoization
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(grid, 0, 0);
    }
}
class Solution {
    int m;
    int n;
    int[][] dp;

    public int minPathSum(int[][] grid) {//O(m*n)
        // tabulation
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        // dp[i][j] represents min path sum from (i,j) to (m-1,n-1)
        // last row and last col should be just additions in backwards
        // as last row and last col has only way to either move downwards straight or rightwards straight
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int row = m-2;row>=0;row--){
            dp[row][n-1] = dp[row+1][n-1] + grid[row][n-1];
        }
        for(int col = n-2;col>=0;col--){
            dp[m-1][col] = dp[m-1][col+1] + grid[m-1][col];
        }
        // now for remaining fill from backwards such that 
        // dp[i][j] = grid[i][j] + min(dp[i+1][j],dp[i][j+1])
        for(int row = m-2;row>=0;row--){
            for(int col = n-2;col>=0;col--){
                dp[row][col] = grid[row][col] + Math.min(dp[row+1][col],dp[row][col+1]);
            }
        }
        return dp[0][0];
    }
}
