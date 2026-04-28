class Solution {
    public boolean isIsomorphic(String s, String t) {
        // TC : O(n)
        // SC : O(1)
        // s[i]->t[i]
        Map<Character, Character> map1 = new HashMap<>();
        // t[i] -> s[i]
        Map<Character, Character> map2 = new HashMap<>();
        int m = s.length();
        int n = t.length();
        if(m != n) return false;
        for(int i = 0;i < n;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map1.containsKey(c1)){
                if(map1.get(c1) != c2) return false;
            }
            else{
                if(map2.containsKey(c2)){
                    if(map2.get(c2) != c1) return false;
                }
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }
        return true;
    }
}
