class Solution {
    int n;
    long[] prefix;

    private long solve(int s, int e, int encCost, int flatCost) {
        long L = e - s + 1;//length 
        long X;
        if (s != 0)
            X = prefix[e] - prefix[s - 1];//no. of 1s in that
        else
            X = prefix[e];//no. of 1s = prefix sum till e then
        //find cost of this string
        long curr_s_cost = (X == 0) ? flatCost : L * X * encCost;
        if (L % 2 == 1) {
            // is length odd
            return curr_s_cost;
        }
        // if length is even
        int mid = s + (e - s) / 2;
        long totalPartitionCost = solve(s, mid, encCost, flatCost) + solve(mid + 1, e, encCost, flatCost);
        return Math.min(curr_s_cost, totalPartitionCost);
    }

    public long minCost(String s, int encCost, int flatCost) {
        n = s.length();
        prefix = new long[n];
        prefix[0] = (char) s.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (char) (s.charAt(i) - '0');
        }
        return solve(0, n - 1, encCost, flatCost);
    }
}
