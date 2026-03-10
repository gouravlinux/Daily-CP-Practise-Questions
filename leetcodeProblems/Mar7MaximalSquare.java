class Solution {
    int m;
    int n;
    int maxi;
    int[][] dp;

    private int solve(char[][] matrix, int i, int j) {
        if (i >= m || j >= n)
            return 0;//no square can be formed from there
        if (dp[i][j] != -1) return dp[i][j];
        int right = solve(matrix, i, j + 1);//itne squares can be formed on right
        int down = solve(matrix, i + 1, j);
        int diagonal = solve(matrix, i + 1, j + 1);
        int ans = 0;
        if (matrix[i][j] == '1')
            ans = 1 + Math.min(right, Math.min(down, diagonal));
        // else ans = 0
        maxi = Math.max(maxi, ans);
        return dp[i][j] = ans;
    }

    public int maximalSquare(char[][] matrix) {
        // using recursion + memoization
        m = matrix.length;
        n = matrix[0].length;
        maxi = 0;
        dp = new int[m][n];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        solve(matrix, 0, 0);
        return maxi * maxi;//return area
    }
}
class Solution {
    int m;
    int n;
    int maxi;
    int[][] dp;

    public int maximalSquare(char[][] matrix) {
        // using tabulation
        m = matrix.length;
        n = matrix[0].length;
        maxi = 0;
        dp = new int[m+1][n+1];
        for(int i = 0;i <= m;i++){
            dp[i][n] = 0;
        }
        for(int j = 0;j <= n;j++){
            dp[m][j] = 0;
        }
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else{
                    int right = dp[i][j+1];
                    int down = dp[i + 1][j];
                    int diagonal = dp[i + 1][j + 1];
                    dp[i][j]=1 + Math.min(right, Math.min(down,diagonal));
                    maxi = Math.max(maxi, dp[i][j]);
                }
            }
        }
        return maxi * maxi;//return area
    }
}
class Solution {
    int m;
    int n;
    int maxi;
    int[] currRow;
    int[] nextRow;

    public int maximalSquare(char[][] matrix) {
        // using tabulation -> space optimization
        m = matrix.length;
        n = matrix[0].length;
        maxi = 0;
        currRow = new int[n + 1];
        nextRow = new int[n + 1];
        // no need of base cases (already every cell is 0)
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '0')
                    currRow[j] = 0;
                else {
                    int right = currRow[j + 1];
                    int down = nextRow[j];
                    int diagonal = nextRow[j + 1];
                    currRow[j] = 1 + Math.min(right, Math.min(down, diagonal));
                    maxi = Math.max(maxi, currRow[j]);
                }
            }
            nextRow = currRow.clone();
        }
        return maxi * maxi;//return area
    }
}
class Solution {
    int m;
    int n;
    int maxi;

    public int maximalSquare(char[][] matrix) {
        // using tabulation -> space optimization(modify existing matrix)
        m = matrix.length;
        n = matrix[0].length;
        maxi = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] != '0'){
                    int right = (j + 1 < n) ? matrix[i][j + 1] - '0' : 0;
                    int down = (i + 1 < m) ? matrix[i + 1][j] - '0' : 0;
                    int diagonal = (i + 1 < m && j + 1 < n) ? matrix[i + 1][j + 1] - '0' : 0;
                    int val = 1 + Math.min(right, Math.min(down, diagonal));
                    matrix[i][j] = (char) (val + '0');
                    maxi = Math.max(maxi, val);
                }
            }
        }
        return maxi * maxi;//return area
    }
}
