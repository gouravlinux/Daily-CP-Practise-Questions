class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // TC : O(n^2)
        // SC : O(1)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = i + 1; j <= i + k && j < n; j++) {
                int y = nums[j];
                if (x == y)
                    return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int x = nums[i];
            if(map.containsKey(x)){
                if(Math.abs(map.get(x)-i) <= k){
                    return true;
                }
            }
            map.put(x, i);
        }
        return false;
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // TC : O(n) as atmost 1 time only we add and remove an element
        // SC : O(min(n,k))-> as atmost k values are stored in set at a time
        int n = nums.length;
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        while(i < n){
            while(j < n && Math.abs(i-j) <= k){
                int x = nums[j];
                if(set.contains(x)){
                    return true;
                }
                set.add(x);
                j++;
            }   
            set.remove(nums[i]);
            i++;
        }
        return false;
    }
}
