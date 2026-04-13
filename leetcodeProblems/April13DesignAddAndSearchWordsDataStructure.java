class TrieNode{
    boolean isEndOfWord;
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode crawler = root;
        for(char ch: word.toCharArray()){
            int idx = ch-'a';
            if(crawler.children[idx] == null){
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEndOfWord = true;
    }
    
    public boolean search(String word, TrieNode crawler){
        for(int j = 0;j < word.length();j++){
            char ch = word.charAt(j);
            if(ch == '.'){
                for(int i = 0;i < 26;i++){//a, b, c....z
                    if(crawler.children[i] != null){
                        if(search(word.substring(j+1),crawler.children[i]) == true){
                            return true;
                        }
                    }
                }
                return false;
            }
            int idx = ch - 'a';
            if(crawler.children[idx] == null) return false;
            crawler = crawler.children[idx];
        }
        if(crawler != null && crawler.isEndOfWord == true){
            return true;
        }
        return false;
    }
    public boolean search(String word) {
        return search(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
