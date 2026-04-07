class Solution {
    int n;
    private int findFirstOcc(int[] nums, int target){
        int s = 0;
        int e = n-1;
        int ans = -1;
        while(s <= e){
            int mid = s+(e-s)/2;
            if(nums[mid] == target){
                ans = mid;
                // search in left half, is target present there also?
                e = mid-1;
            }
            else if(nums[mid] > target){
                // search in left half
                e = mid-1;
            }
            else{
                // nums[mid] < target
                s = mid+1;
            }
        }
        return ans;
    }
    private int findLastOcc(int[] nums,int target){
        int s = 0;
        int e = n-1;
        int ans = -1;
        while(s <= e){
            int mid = s+(e-s)/2;
            if(nums[mid] == target){
                ans = mid;
                s = mid+1;
            }
            else if (nums[mid] > target){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        // TC : O(log n)
        // SC : O(1)
        n = nums.length;
        int[] arr = new int[2];
        arr[0] = findFirstOcc(nums, target);
        arr[1] = findLastOcc(nums, target);
        return arr;
    }
}
