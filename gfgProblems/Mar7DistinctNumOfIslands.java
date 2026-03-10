// User function Template for Java

class Solution {
    int n;
    int m;
    int[][] directions = { {-1,0},{0,-1},{1,0},{0,1} };

    private boolean isValid(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;
        else
            return true;
    }
    void dfs(int[][] grid,int i,int j,List<List<Integer>> ls,int baseRow,int baseCol){
        if (!isValid(i,j)||grid[i][j]!=1) return;
        grid[i][j] = -1;//mark as visited
        ls.add(new ArrayList<>(Arrays.asList(i-baseRow,j-baseCol)));
        for(int[] dir: directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(isValid(new_i,new_j)&&grid[new_i][new_j]==1){
                dfs(grid,new_i,new_j,ls,baseRow,baseCol);
            }
        }
        
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
	// using dfs
        n = grid.length;
        m = grid[0].length;
        Set<List<List<Integer>>> st = new HashSet<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                List<List<Integer>> ls = new ArrayList<>();
                if (grid[i][j] == 1){
                    dfs(grid, i, j, ls, i, j);
                    st.add(new ArrayList<>(ls));
                }
            }
        }
        return st.size();
    }
}
// User function Template for Java

class Solution {
    int n;
    int m;
    int[][] directions = { {-1,0},{0,-1},{1,0},{0,1} };

    private boolean isValid(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;
        else
            return true;
    }
    void bfs(int[][] grid,int i,int j,List<List<Integer>> ls,int baseRow,int baseCol){
        if (!isValid(i,j)||grid[i][j]!=1) return;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        grid[i][j] = -1;//mark as visited
        ls.add(new ArrayList<>(Arrays.asList(i-baseRow,j-baseCol)));
        while(!que.isEmpty()){
            int[] item = que.poll();
            for(int[] dir: directions){
                int new_i = item[0] + dir[0];
                int new_j = item[1] + dir[1];
                if(isValid(new_i,new_j)&&grid[new_i][new_j]==1){
                    que.add(new int[]{new_i,new_j});
                    grid[new_i][new_j] = -1;//mark as visited
                    ls.add(new ArrayList<>(Arrays.asList(new_i-baseRow,new_j-baseCol)));
                }
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        // using bfs
        n = grid.length;
        m = grid[0].length;
        Set<List<List<Integer>>> st = new HashSet<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                List<List<Integer>> ls = new ArrayList<>();
                if (grid[i][j] == 1){
                    bfs(grid, i, j, ls, i, j);
                    st.add(new ArrayList<>(ls));
                }
            }
        }
        return st.size();
    }
}

