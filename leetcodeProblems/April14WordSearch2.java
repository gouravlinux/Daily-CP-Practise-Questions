class TrieNode{
    String word;
    boolean isEndOfWord;
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
class Solution {
    int m;
    int n;
    List<String> res;
    int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};
    private boolean isValid(int i,int j){
        if(i < 0 || j < 0 || i >= m || j >= n){
            return false;
        }
        return true;
    }
    private void search(char[][] board, int i,int j, TrieNode root){
        if(!isValid(i, j) || board[i][j] == '$'){
            // out-of-bounds or already visited
            return;
        }
        // traverse trie data structure
        char ch = board[i][j];
        int idx = ch - 'a';
        TrieNode childNode = root.children[idx];
        if(childNode == null){
            return;
        }
        else{
            // if present
            // see if it is the endOfWord or not
            if(childNode.isEndOfWord == true){
                res.add(childNode.word);
                childNode.isEndOfWord = false;// as we have added it
            }
            // if not endOfWord
            // first mark this as visited
            board[i][j] = '$';
            // explore its left, right, up and down
            for(int[] dir: directions){
                int new_i = i + dir[0];
                int new_j = j + dir[1];
                search(board, new_i, new_j, childNode);
            }
            // after exploration : backtrack
            board[i][j] = ch;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        // build the Trie Data Structure
        TrieNode root = new TrieNode();
        for(String str: words){
            TrieNode crawler = root;
            for(char ch: str.toCharArray()){
                int idx = ch - 'a';
                if(crawler.children[idx] == null){
                    crawler.children[idx] = new TrieNode();
                }
                crawler = crawler.children[idx];
            }
            crawler.isEndOfWord = true;
            crawler.word = str;
        }
        res = new ArrayList<>();
        // search matrix acc. to built Trie-Data structure
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                search(board, i, j, root);
            }
        }
        return res;
    }
}
