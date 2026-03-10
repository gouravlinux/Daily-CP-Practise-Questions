class trieNode{
    boolean isEndOfWord;
    trieNode[] children = new trieNode[26]; 
}
class Trie {
    trieNode root;
    public trieNode getNode(){
        trieNode newNode = new trieNode();
        newNode.isEndOfWord = false;
        for(int i = 0;i < 26;i++){
            newNode.children[i] = null;
        }
        return newNode;
    }
    public Trie() {
        root = getNode();
    }
    
    public void insert(String word) { // apple
        trieNode crawler = root;  
        for (char ch: word.toCharArray()){
            int idx = ch-'a';
            if (crawler.children[idx] == null){
                crawler.children[idx] = getNode();//'a'
            }
            crawler = crawler.children[idx];
        }
        crawler.isEndOfWord = true;//'e'
    }
    
    public boolean search(String word) {
        trieNode crawler = root;  
        for (char ch: word.toCharArray()){
            int idx = ch-'a';
            if (crawler.children[idx] == null){
                return false;
            }
            crawler = crawler.children[idx];
        }
        if (crawler != null && crawler.isEndOfWord == true) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        trieNode crawler = root;  
        int i = 0;
        for (char ch: prefix.toCharArray()){
            int idx = ch-'a';
            if (crawler.children[idx] == null){
                return false;
            }
            crawler = crawler.children[idx];
            i++;
        }
        if (i == prefix.length()) return true;
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
