class Solution {
    public List<String> summaryRanges(int[] nums) {
        // TC : O(n)
        // SC : O(n): in worst case there would be all distinct elements
        // and therefore n different nos. (with no range) in the list
        List<String> resList = new ArrayList<>();
        int n = nums.length;
        if (n == 0)
            return resList;
        for (int i = 0; i < n; i++) {
            int start = nums[i];
            int end = nums[i];
            int j = i+1;
            while(j < n && end+1 == nums[j]){
                end = nums[j];
                j++;
            }
            i = j-1;
            StringBuilder str = new StringBuilder();
            if(start == end){
                str.append(start);
            }
            else{
                // if start != end
                str.append(start);
                str.append("->");
                str.append(end);
            }
            resList.add(str.toString());
        }
        return resList;
    }
}


class Solution {
    public List<String> summaryRanges(int[] nums) {
	// TC : O(n)
	// SC : O(n)
        int n = nums.length;
        List<String> resList = new ArrayList<>();
        if(n == 0) return resList;
        for(int i = 0;i < n;i++){
            int start = nums[i];
            while(i+1 < n && nums[i+1] == nums[i]+1){
                i++;
            }
            if(start != nums[i]){
                resList.add(Integer.toString(start)+"->"+Integer.toString(nums[i]));
            }
            else{
                resList.add(Integer.toString(start));
            }
        }
        return resList;
    }
}
