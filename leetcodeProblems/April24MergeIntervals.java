class Solution {
    public int[][] merge(int[][] intervals) {
        // TC : O(nlogn+n)
        // SC : O(2n)
        int n = intervals.length;
        if(n == 1) return intervals;
        Arrays.sort(intervals, (a,b)->{
            return a[0] - b[0];
        });
        List<int[]> list = new ArrayList<>();
        int prev_start = intervals[0][0];
        int prev_end = intervals[0][1];
        for(int i = 1;i < n;i++){
            int new_start = intervals[i][0];
            int new_end = intervals[i][1];
            if(prev_end >= new_start){
                // intervals are overlapping
                prev_start = Math.min(prev_start, new_start);
                prev_end = Math.max(prev_end, new_end);
            }else{
                // intervals are non-overlapping
                // first push in the list
                list.add(new int[]{prev_start, prev_end});
                // new prev_starts and prev_ends
                prev_start = new_start;
                prev_end = new_end;
            }
        }
        // one more time add to list, as the last saved 
        // prev_start and prev_end were not saved
        list.add(new int[]{prev_start, prev_end});
        // now form the array
        n = list.size();
        int[][] resArr = new int[n][];
        for(int i = 0;i < n;i++){
            int[] arr = list.get(i);
            resArr[i] = arr;
        }
        return resArr;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        // TC : O(nlogn+n)
        // SC : O(2n)
        int n = intervals.length;
        if(n == 1) return intervals;
        Arrays.sort(intervals, (a,b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        List<int[]> list = new ArrayList<>();
        int prev_start = intervals[0][0];
        int prev_end = intervals[0][1];
        for(int i = 1;i < n;i++){
            int new_start = intervals[i][0];
            int new_end = intervals[i][1];
            if(prev_end >= new_start){
                // intervals are overlapping
                prev_start = Math.min(prev_start, new_start);
                prev_end = Math.max(prev_end, new_end);
            }else{
                // intervals are non-overlapping
                // first push in the list
                list.add(new int[]{prev_start, prev_end});
                // new prev_starts and prev_ends
                prev_start = new_start;
                prev_end = new_end;
            }
        }
        // one more time add to list, as the last saved 
        // prev_start and prev_end were not saved
        list.add(new int[]{prev_start, prev_end});
        // now form the array
        n = list.size();
        int[][] resArr = new int[n][];
        for(int i = 0;i < n;i++){
            int[] arr = list.get(i);
            resArr[i] = arr;
        }
        return resArr;
    }
}
