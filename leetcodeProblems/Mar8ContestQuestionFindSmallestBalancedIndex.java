class Solution {
    public int smallestBalancedIndex(int[] nums) {
        // max sum possible = 10^9 * 10^5 = 10^14
        int n = nums.length;
        int ans = -1;
        long prod = 1;
        long LIMIT = (long)Math.pow(10, 14);
        long[] prodArr = new long[n+1];
        prodArr[n] = 1;
        for(int i = n-1;i>=0;i--){
            // to prevent multiplication overflow
            prodArr[i] = Math.min(nums[i] * prodArr[i+1], LIMIT+1);
        }
        long sum = 0;
        for(int i = 0;i < n;i++){
            if(sum == prodArr[i+1]){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
