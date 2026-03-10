class Solution {
    int m;
    int n;
    int bndCnt;

    private void dfs(int[][] grid, int i, int j) {
        //Traverse connected land cells via DFS and count boundaries where neighbors are water or out of bounds.
        if (i < 0 || j < 0 || i == m || j == n) {//out-of-bounds
            bndCnt++;
            return;
        }
        if (grid[i][j] == 0) {
            // out-of-island in water
            bndCnt++;
            return;
        }
        if (grid[i][j] == -1) {
            // already visited
            return;
        }
        grid[i][j] = -1;//mark this cell as visited
        // explore its neighbours
        dfs(grid, i, j + 1);//left
        dfs(grid, i + 1, j);//down
        dfs(grid, i - 1, j);//top
        dfs(grid, i, j - 1);//right
    }

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        //DFS
        bndCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return bndCnt;
                }
            }
        }
        return bndCnt;
    }
}
class Solution {
    int m;
    int n;
    int bndCnt;
    int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};
    private boolean isValid(int i,int j){
        if (i < 0 || i>=m || j<0 || j>=n)
            return false;
        else
            return true;
    }
    private void bfs(int[][] grid,int i,int j){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        grid[i][j] = -1;//mark visited
        while(!que.isEmpty()){
            int[] item = que.poll();
            for(int[] dir: directions){
                int new_i = item[0] + dir[0];
                int new_j = item[1] + dir[1];
                if (!isValid(new_i,new_j) || grid[new_i][new_j] == 0)
                    bndCnt++;
                else if (grid[new_i][new_j] == -1){
                    // already visited
                    continue;
                }
                else{
                    // value is 1
                    que.add(new int[]{new_i,new_j});
                    grid[new_i][new_j] = -1;
                }
            }
        }
    }
    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        bndCnt = 0;
        // BFS
        for(int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1){
                    bfs(grid, i, j);
                    return bndCnt;
                }
            }
        }
        return bndCnt;
    }
}
class Solution {
    int m;
    int n;
    int bndCnt;
    int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    private boolean isValid(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;
        else
            return true;
    }

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        bndCnt = 0;
        // simple 2D array traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } else {
                    // grid[i][j] = 1;
                    for (int[] dir : directions) {
                        int new_i = i + dir[0];
                        int new_j = j + dir[1];
                        if (!isValid(new_i, new_j) || grid[new_i][new_j] == 0) {
                            bndCnt++;
                        }
                    }
                }
            }
        }
        return bndCnt;
    }
}
