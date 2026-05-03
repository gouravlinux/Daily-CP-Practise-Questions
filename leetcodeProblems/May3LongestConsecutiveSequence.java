class Solution {
    int n;
    private boolean linearSearch(int[] nums,int x){
        for(int i = 0;i < n;i++){
            if(x == nums[i]) return true;
        }
        return false;
    }
    public int longestConsecutive(int[] nums) {
        // TC : O(n^2)
        // SC : O(1)
        n = nums.length;
        if(n == 0) return 0;
        int longest = 1;
        for(int i = 0;i < n;i++){
            int x = nums[i];
            int cnt = 1;
            while(linearSearch(nums, x+1) == true){
                x++;
                cnt++;
                longest = Math.max(cnt, longest);
            }
        }
        return longest;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        // TC : O(nlogn+n)
        // SC : O(1)
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int currCnt = 1;
        int longest = 1;
        int lastSmaller = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            int x = nums[i];
            if (lastSmaller+1 == x){
                currCnt++;
                lastSmaller = x;
            }
            else if (lastSmaller != x){
                currCnt = 1;
                lastSmaller = x;
            }
            longest = Math.max(currCnt, longest);
        }
        return longest;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        // TC : O(3n)
        // SC : O(n) -> for set
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int num: nums){//O(n)
            set.add(num);
        }
        for(int num: set){//O(2n)->O(n)
            if(set.contains(num-1)) continue;//not starting pt. of range
            int cnt = 1;
            while(true){//O(n)
                if(set.contains(num+1)){
                    num++;
                    cnt++;
                    
                }else{
                    break;
                }
            }
            longest = Math.max(cnt, longest);
        }
        return longest;
    }
}
