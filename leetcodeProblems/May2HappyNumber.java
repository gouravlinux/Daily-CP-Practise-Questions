class Solution {
    public boolean isHappy(int n) {
        // TC : O(1)
        // SC : O(1)
        // as sum will not exceed 1000: sum of squares of 2^31 = 275
        // therefore O(1000) is also very much -> O(1)
        Set<Integer> visited = new HashSet<>();
        while (n != 1) {
            if(visited.contains(n)) return false;
            visited.add(n);
            int ans = 0;
            while (n > 0) {
                ans += (int) Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = ans;
        }
        return true;
    }
}
