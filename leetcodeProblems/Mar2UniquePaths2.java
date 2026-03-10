class Solution {
    int m;
    int n;
    int[][] dp;
    private int solve(int[][] obstacleGrid, int i,int j){
        if (i >= m || j >= n) return 0;//no path to reach (m-1,n-1)
        if (obstacleGrid[i][j] == 1) return 0;//obstacle present 
        if (i == m-1 && j == n-1) return 1;//a path was found
        if (dp[i][j] != -1) return dp[i][j];
        int downPaths = solve(obstacleGrid, i+1, j);
        int rightPaths = solve(obstacleGrid, i,j+1);
        return dp[i][j] = downPaths + rightPaths;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // using recursion + memoization
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(obstacleGrid, 0, 0);
    }
}
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {//O(m*n)
        // using tabulation
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // dp[i][j] -> unique paths present from (i,j) to (m-1,n-1)
        // last row and last column only has one unique path
        dp[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
        for (int row = m - 2; row >= 0; row--) {
            if (obstacleGrid[row+1][n-1] == 1){
                //obstacle present in next
                dp[row][n-1] = 0;
                obstacleGrid[row][n-1] = 1;//no way to reach
            }
            else if (obstacleGrid[row][n-1] == 1)//current cell has obstacle
                dp[row][n-1] = 0;
            else//no obstacle
                dp[row][n-1] = 1;
        }
        for (int col = n - 2; col >= 0; col--) {
            if (obstacleGrid[m-1][col+1] == 1){
                //obstacle present in next
                dp[m-1][col] = 0;
                obstacleGrid[m-1][col] = 1;//no way to reach
            }
            else if (obstacleGrid[m-1][col] == 1)//obstacle present in current cell
                dp[m-1][col] = 0;
            else//no obstacle
                dp[m-1][col] = 1;
        }
        // remaining values filled in reverse such that 
        // dp[i][j] = dp[i+1][j] + dp[i][j+1]
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                if (obstacleGrid[row][col] == 1)//obstacle present
                    dp[row][col] = 0;//can't reach from there
                else//no obstacle present on current cell
                    dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }
        }
        return dp[0][0];
    }
}
