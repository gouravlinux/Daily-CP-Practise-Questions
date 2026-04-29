class Solution {
    public boolean wordPattern(String pattern, String s) {
        // TC : O(n)
        // SC : O(m+26)
        String[] words = s.split(" ");
        int n = pattern.length();
        int m = words.length;
        if (n != m)
            return false;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (map1.containsKey(ch)) {
                if (!word.equals(map1.get(ch))) {
                    return false;
                } else {
                    if (!map2.containsKey(word) || ch != map2.get(word)) {
                        return false;
                    }
                }
            } else {
                if (!map2.containsKey(word)) {
                    // new ch and word 
                    map1.put(ch, word);
                    map2.put(word, ch);
                } else {
                    if (ch != map2.get(word))
                        return false;
                    map1.put(ch, word);
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        // TC : O(2n)
        // SC : O(n + k) k -> max size 26
        String[] words = s.split(" ");
        int n = words.length;
        int m = pattern.length();
        if (n != m)
            return false;
        Set<Character> usedCharSet = new HashSet<>();
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (!map.containsKey(word)) {
                if (!usedCharSet.contains(ch)) {
                    map.put(word, ch);
                    usedCharSet.add(ch);
                }else{
                    return false;// ch is already mapped to another word
                }
            }else{
                if(map.get(word) != ch) return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        // TC : O(m+n)
        // SC : O(n)
        String[] words = s.split(" ");
        int n = words.length;
        int m = pattern.length();
        if (n != m)
            return false;
        Map<Character, Integer> charToIdxMap = new HashMap<>();
        Map<String, Integer> strToIdxMap = new HashMap<>();
        for(int i = 0;i < n;i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(!charToIdxMap.containsKey(ch)){
                if(!strToIdxMap.containsKey(word)){
                    charToIdxMap.put(ch, i);
                    strToIdxMap.put(word, i);
                }else{
                    return false;
                }
            }else{
                if(!strToIdxMap.containsKey(word)){
                    return false;
                }else{
                    if((int)strToIdxMap.get(word) != (int)charToIdxMap.get(ch)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
