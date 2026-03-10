class Solution {
    int n;
    int[][] dp;
    private int solve(int[] nums,int i,int prev){O(n^2)
        if (i >= n) return 0;
        if (prev != -1 && dp[i][prev] != -1) return dp[i][prev];
        int take = 0;
        if (prev == -1 || nums[prev] < nums[i])
        // if we didn't took any element till now or prev is < i
            take = 1 + solve(nums, i+1, i);//prev becomes i
        int skip = 0 + solve(nums, i+1, prev);
        if (prev != -1)
            dp[i][prev] = Math.max(take, skip);
        return Math.max(take, skip);
    }
    public int lengthOfLIS(int[] nums) {
        // recursion + memoization
        n = nums.length;
        dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(nums, 0, -1);
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {//O(n^2)
        int n = nums.length;
        // tabulation
        // dp[i] repreents LIS till index i
        int[] dp = new int[n];
        Arrays.fill(dp, 1);//every element is itself LIS
        int maxLIS = 1;//atleast one of the element is present in LIS
        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if (nums[j]<nums[i]){
                    // if prev is smaller
                    // add with its own LIS
                    dp[i] = Math.max(dp[i], 1 + dp[j]);//add that element 
                    maxLIS = Math.max(maxLIS, dp[i]);
                    
                }//else can't add to dp[i]
            }
        }
        return maxLIS;
    }
}
class Solution {
    private int binSrch(List<Integer> temp,int val){ //logn
        int ans = -1;
        int s = 0;
        int e = temp.size()-1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if (temp.get(mid) >= val){
                e = mid-1;
                ans = mid;
            }
            else{
                s = mid+1;
            }
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        // using patience sort
        // make ls
        // iterate over every element x(i), 
        // if element x < any element in ls-> replace with x
        // else add the element in the list
        List<Integer> temp = new ArrayList<>();
        for(int val: nums){// - n
            if (temp.size() == 0) temp.add(val);
            else{
                // implement binSrch for finding an element in temp >= val
                int idx = binSrch(temp, val);
                if (idx != -1) temp.set(idx, val);
                else temp.add(val);
            }
        }
        return temp.size();//O(nlogn)
    }
}
