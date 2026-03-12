class Solution {
    int n;
    boolean[][] visited;
    private int[] getCoord(int val) {
        // getting row
        int row_from_top = (val - 1) / n;
        int row_from_bottom = (n - 1) - row_from_top;
        int col_from_bottom;
        int col_from_top = (val - 1) % n;
        boolean evenRowsAreLeftToRight = false;
        if ((n - 1) % 2 == 0) {
            // last row is even
            // even rows are left to right
            evenRowsAreLeftToRight = true;
        }
        // else evenRowsAreNotLeftToRight = false;

        if ((row_from_bottom % 2 == 0 && evenRowsAreLeftToRight) || (row_from_bottom % 2 != 0 && !evenRowsAreLeftToRight)) {
                col_from_bottom = col_from_top;// as it is
        } else {
            col_from_bottom = (n - 1) - col_from_top;
        }
        return new int[] { row_from_bottom, col_from_bottom };
    }

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        // using BFS
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[n][n];
        // add 1 to que
        que.add(1);
        visited[n-1][0] = true;
        int steps = 0;
        
        while (!que.isEmpty()) {
            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                int num = que.poll();
                if (num == n * n)//found the target
                    return steps;
                for (int k = 1; k <= 6; k++) {
                    // die nos. for incrementing = (1,2,3..6)
                    int val = num + k;
                    if (val > n * n)
                        break;//invalid cell
                    int[] coord = getCoord(val);
                    int r = coord[0];
                    int c = coord[1];
                    // if already visited: don't add in queue
                    if(visited[r][c]){
                        continue;
                    }
                    visited[r][c] = true;
                    if (board[r][c] == -1) {
                        // no snake or ladder present
                        // simply push in queue
                        que.add(val);
                        
                    } else {
                        // snake or ladder present
                        // push the value of board[r][c]
                        que.add(board[r][c]);
                    }
                }
            }
            // every level
            steps++;
        }
        return -1;
    }
}
