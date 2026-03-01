class Solution {
    int m;// no. of rows
    int[][] dp;
    private int solve(List<List<Integer>> triangle, int i,int j){
        if (i == m-1) return triangle.get(i).get(j);//base case: on last row
        // each row i has i+1 columns(elements)
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int leftSum = solve(triangle, i+1, j);
        int rightSum = solve(triangle, i+1, j+1);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(leftSum, rightSum);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        m = triangle.size();
        dp = new int[m+1][m+1];
        for(int[] row: dp) Arrays.fill(row, Integer.MAX_VALUE);
        // recursion + memoization
        return solve(triangle, 0, 0);
    }
}
class Solution {
    int m;
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        // bottom-up
        m = triangle.size();//total no. of rows
        dp = new int[m][];
        for(int i = 0;i < m;i++){
            dp[i] = new int[i+1];
        }
        for(int i = 0;i < m;i++){
            for (int j = 0;j <= i;j++){
                dp[i][j] = triangle.get(i).get(j);
            }
        }
        // last row (m-1) would be as it is
        // iterate from m-2 to 0
        // dp[i][j] = min. path sum from (i,j) till bottom
        for(int i = m-2;i>=0;i--){
            for(int j = 0;j<=i;j++){
                dp[i][j] += Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];// min cost from top to bottom
    }
}
class Solution {
    int n;//no. of rows
    int[] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        // tabulation + space optimization
        // store dp = last row of triangle
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        return dp[0];//min path sum from 0 to n-1th row
    }
}//code takes O(n) SC and O(n^2) TC
