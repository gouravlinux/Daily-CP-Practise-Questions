class Solution {
    List<List<String>> res;
    int[] col;
    private boolean clash(int row, int n){
        int column = col[row];
        for(int otherQueenRow = 0;otherQueenRow < row;otherQueenRow++){
            if(column == col[otherQueenRow]){
                // clash
                return true;//in same column
            }
            if(Math.abs(column - col[otherQueenRow]) == Math.abs(row-otherQueenRow)){
                // in diagonal
                return true;
            }
        }
        return false;//no clash
    }
    private List<String> makeString(int n){
        List<String> temp = new ArrayList<>();
        for(int row = 0; row < n;row++){
            StringBuilder newString = new StringBuilder();
            for(int column = 0;column<n;column++){
                if(column == col[row]){
                    newString.append('Q');
                    continue;
                }
                newString.append('.');
            }
            temp.add(newString.toString());
        }
        return temp;
    }
    private void solve(int i, int n){// i represent row no.
        if(i == n){
            List<String> temp = makeString(n);
            res.add(temp);
            return;
        }
        for(int colNo = 0;colNo < n;colNo++){
            col[i] = colNo;
            if(clash(i,n)){
                continue;
            } 
            // else
            solve(i+1, n);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        col = new int[n];
        res = new ArrayList<>();
        solve(0, n);
        return res;
    }
}
