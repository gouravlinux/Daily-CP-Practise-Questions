class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x,y)->Integer.compare(x[0],y[0]));->O(nlogn)
        // determine the non-overlapping intervals
        int count = 0;
        int i = 1;
        int[] lastInterval = points[0];
        int n = points.length;
        while(i < n){
            int prevStart = lastInterval[0];
            int prevEnd = lastInterval[1];
            int currStart = points[i][0];
            int currEnd = points[i][1];
            if (prevEnd < currStart){
                // non-overlapping case
                lastInterval = points[i];
                i++;
            }
            else if (prevEnd <= currEnd){
                // overlapping case
                // delete ith interval
                // lastInterval stays same
                i++;
                count++;
            }
            else if (prevEnd > currEnd){
                // overlapping case
                // delete lastInterval
                lastInterval = points[i];
                i++;
                count++;
            }
        }
        int arrCnt = n - count;
        return arrCnt;
    }
}
