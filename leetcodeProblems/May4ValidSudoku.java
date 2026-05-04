class Solution {
    int n;

    private boolean isValidBox(char[][] board, int startRow, int startCol) {
        int endRow = startRow + 2;
        int endCol = startCol + 2;
        Set<Character> set = new HashSet<>();
        for (int row = startRow; row <= endRow && row < n; row++) {
            for (int col = startCol; col <= endCol && col < n; col++) {
                if (board[row][col] == '.')
                    continue;
                if (set.contains(board[row][col]))
                    return false;
                set.add(board[row][col]);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        // TC : O(1) -> as everytime we are only iterating over 9 rows or 9 columns 
        // and all are constant operation as n is not growing
        // SC : O(1) as set at max only stores 9 values
        n = board.length;
        // find if any row has duplicates or not
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j]))
                    return false;//not valid
                set.add(board[i][j]);
            }
        }
        // find if any column has duplicates or not
        for (int j = 0; j < n; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        // find if any 3x3 box contains duplicate or not
        for (int startRow = 0; startRow < n; startRow += 3) {
            for (int startCol = 0; startCol < n; startCol += 3) {
                if (!isValidBox(board, startRow, startCol))
                    return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
	// TC : O(1) (as n doesnot grow)
	// SC : O(1) (as set will contain max 9*9*3 values at max only)
        int n = 9;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    continue;
                String s1 = "i = " + i + " ->" + board[i][j];//in same row
                String s2 = "j = " + j + " ->" + board[i][j];//in same column
                int boxRow = i / 3;
                int boxCol = j / 3;
                String s3 = "i = " + boxRow + ", " + "j = " + boxCol + " ->" + board[i][j];//in same box
                if (set.contains(s1) || set.contains(s2) || set.contains(s3))
                    return false;
                set.add(s1);
                set.add(s2);
                set.add(s3);
            }
        }
        return true;
    }
}

