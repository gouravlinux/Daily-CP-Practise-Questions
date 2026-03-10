class Solution {
    int[] dp;
    int n;
    private int solve(int[] nums,int idx){
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];
        int steal = nums[idx] + solve(nums, idx+2);// as I can't rob adj. house
        int skip = 0 + solve(nums, idx+1);// now I can rob adj. house
        dp[idx] = Math.max(steal, skip);
        return dp[idx];
    }
    public int rob(int[] nums) {
        // recursion+memoization solution
        n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
}
class Solution {
    int n;
    int[] dp;
    public int rob(int[] nums) {
        // tabulation
        n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);// loot either current or previous(not both)
        // dp[i] -> till ith house, max. loot I can perform
        for(int i = 2;i < n;i++){
            int skip = 0 + dp[i-1];
            int steal = nums[i] + dp[i-2];
            dp[i] = Math.max(skip, steal);
        }
        return Math.max(dp[n-1], dp[n-2]);
    }
}
