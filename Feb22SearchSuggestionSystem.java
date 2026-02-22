class Solution {
    public List<String> suggestProds(String[] products, String searchPrefix){
        List<String> resArr = new ArrayList<>();
        int i = 0;
        for (String str: products){
            if (i >= 3){
                break;
            }
            if (str.startsWith(searchPrefix)){
                resArr.add(str);
                i++;
            }
        }
        return resArr;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
	// using Linear Search
        // sort the products in lexiographical order
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0;i < searchWord.length();i++){
            List<String> ans = suggestProds(products, searchWord.substring(0,i+1));
            res.add(ans);
        }
        return res;        
    }
}

class Solution {
    int n;

    private int binSrch(String[] products, String searchPrefix) {
        int idx = -1;
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (products[mid].startsWith(searchPrefix)) {
                idx = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }

    private List<String> suggestProds(String[] products, String searchPrefix) {
        List<String> resArr = new ArrayList<>();
        // applying binary search
        int firstIdx = binSrch(products, searchPrefix);
        if (firstIdx >= 0) {
            resArr.add(products[firstIdx]);
        }
        for (int i = firstIdx + 1; i < n; i++) {
            if (resArr.size() >= 3) {
                break;
            }
            if (products[i].startsWith(searchPrefix)) {
                resArr.add(products[i]);
            }
        }
        return resArr;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
	// using Binary Search
        // sort the products in lexiographical order
        Arrays.sort(products);
        n = products.length;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> ans = suggestProds(products, searchWord.substring(0, i + 1));
            res.add(ans);
        }
        return res;
    }
}

class trieNode{
    boolean isEndOfWord;
    trieNode[] children = new trieNode[26];
}
class Solution {
    public trieNode getNode(){
        trieNode root = new trieNode();
        root.isEndOfWord = false;
        for(int i = 0;i < 26;i++){
            root.children[i] = null;
        }
        return root;
    }
    private void insertWord(trieNode trie, String word){
        for(char ch: word.toCharArray()){
            int idx = ch - 'a';
            if (trie.children[idx] == null){
                trie.children[idx] = getNode();
            }
            trie = trie.children[idx];
        }
        trie.isEndOfWord = true;
    }
    private void dfs(trieNode trie, String pre, List<String> res){
        if (res.size() >= 3){
            return;
        }
        if (trie.isEndOfWord == true){
            res.add(pre);
        }
        for(int i = 0;i < 26;i++){
            if (trie.children[i] != null){
                dfs(trie.children[i], pre+(char)(i+'a'), res);
            }
        }
    }
    private List<String> searchInTrie(trieNode trie, String prefix){
        List<String> res = new ArrayList<>();
        for(char ch: prefix.toCharArray()){
            int idx = ch - 'a';
            if (trie.children[idx] == null){
                return res;
            }
            trie = trie.children[idx];
        }
        dfs(trie, prefix, res);
        return res;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
	// using the Trie Method
        trieNode trie = getNode();
        // build the trie
        for(String prod: products){
            insertWord(trie, prod);
        }
        List<List<String>> res = new ArrayList<>();
        for(int i = 0;i < searchWord.length();i++){
            List<String> strList = searchInTrie(trie, searchWord.substring(0,i+1));
            res.add(strList);
        }
        return res;
    }
}
