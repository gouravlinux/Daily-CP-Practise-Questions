class Solution {
    int n;

    private int binSrch(int[][] temp, int itemSize) {
        int s = 0;
        int e = n - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (temp[mid][0] >= itemSize) {
                ans = temp[mid][1];
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public int minimumIndex(int[] capacity, int itemSize) {
        int ans = -1;
        n = capacity.length;
        int[][] temp = new int[n][];
        for (int i = 0; i < n; i++) {
            temp[i] = new int[] { capacity[i], i };
        }
        Arrays.sort(temp, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];//sort with 0th index
            } else {
                return a[1] - b[1];//sort with 1st index
            }
        });
        ans = binSrch(temp, itemSize);
        return ans;
    }
}
