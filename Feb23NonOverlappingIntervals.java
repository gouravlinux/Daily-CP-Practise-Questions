// all are greedy solutions
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort using start times
        Arrays.sort(intervals, (x,y)->Integer.compare(x[0],y[0]));//O(nlogn)
        // System.out.println(Arrays.toString(intervals));
        int cnt = 0;
        int i = 0;
        int n = intervals.length;
        int j = 1;
        while (j < n) {//O(n)
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            int nextStart = intervals[j][0];
            int nextEnd = intervals[j][1];
            if (currentEnd <= nextStart) {
                // no overlapping
                i = j;
                j++;
            }
            else if (currentEnd <= nextEnd) {
                // overlapping
                j++;
                cnt++;//delete j
            } else if (currentEnd > nextEnd) { // overlapping
                // if currentEnd > nextEnd
                i = j;
                j++;
                cnt++;// delete i
            }
        }
        return cnt;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int n = intervals.length;
        int[] lastInterval = intervals[0];
        int i = 1;
        int count = 0;
        while (i < n) {
            int currEnd = intervals[i][1];
            int currStart = intervals[i][0];
            int lastEnd = lastInterval[1];
            if (currStart >= lastEnd) {
                // safe -> non-overlapping
                lastInterval = intervals[i];
                i++;
            } else if (currEnd >= lastEnd) {
                count++;
                i++;
            } else if (currEnd < lastEnd) {
                count++;
                lastInterval = intervals[i];
                i++;
            }
        }
        return count;
    }
}
