class Solution {
    public boolean isAnagram(String s, String t) {
        // TC : O(n)
        // SC : O(26) -> O(1)
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i = 0;i < n;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0)+1);
            map2.put(c2, map2.getOrDefault(c2, 0)+1);
        }
        return map1.equals(map2);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        // TC : O(n)
        // SC : O(26) -> O(1)
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0;i < n;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            arr1[c1-'a']++;
            arr2[c2-'a']++;
        }
        return Arrays.equals(arr1, arr2);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        // TC : O(nlogn)
        // SC : O(2n)
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        if(arr1.length != arr2.length) return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        // TC : O(2n)
        // SC : O(1)
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(char ch: s.toCharArray()){
            arr[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            int idx = ch - 'a';
            if(arr[idx] == 0) return false;
            arr[idx]--;
        }
        return true;
    }
}
