class Solution {
    private int cnt1s(int num){
        int cnt = 0;
        while(num>0){
            int bit = num&1;
            cnt = bit==1?cnt+1:cnt;
            num = num>>1;
        }
        return cnt;
    }
    public int[] countBits(int n) {
	// simple brute-force approach
        int[] arr = new int[n+1];
        for(int i = 0;i <= n;i++){
            // arr[i] = cnt1s(i);
            arr[i] = Integer.bitCount(i);
        }
        return arr;
    }
}
class Solution {
    int[] dp;
    private int solve(int i){
        if (i == 0) return 0;
        return i%2 + solve(i/2);
    }
    public int[] countBits(int n) {
	// only recursive approach
        dp = new int[n+1];
        for(int i = 0;i <= n;i++){
            dp[i] = solve(i);
        }
        return dp;
    }
}
class Solution {
    int[] dp;
    private int solve(int i){
        if (i == 0) return 0;
        if (dp[i] != -1) return dp[i];
        return dp[i] = i%2 + solve(i/2);
    }
    public int[] countBits(int n) {
	// recursion+memoization approach
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        for(int i = 0;i <= n;i++){
            dp[i] = solve(i);
        }
        return dp;
    }
}
class Solution {
    public int[] countBits(int n) {
	// tabulation approach
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i = 0;i <= n;i++){
            // if even -> same no. of bits like in its half
            if (i%2 == 0)
                res[i] = res[i/2];
            // if odd -> one extra bit than its half
            else
                res[i] = res[i/2]+1;
        }
        return res;
    }
}
