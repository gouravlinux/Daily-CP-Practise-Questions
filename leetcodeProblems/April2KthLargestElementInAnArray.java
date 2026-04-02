class Solution {
    public int findKthLargest(int[] nums, int k) {
        // using sorting
        // TC:O(nlogn), SC: O(1)
        Arrays.sort(nums);//sort the array in descending order
        return nums[nums.length-k];//kth largest element
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // using min heap
        // TC: O(nlogk), SC: O(k) -> size of PQ is k 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);// O(log k)
            while(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}
class Solution {
    int ans;

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int left, int right) {
        // pivot is leftmost index in nums
        int pivot = nums[left];
        int i = left+1;
        int j = right;
        while (i <= j) {
            // while j does not pass i
            if (nums[i] < pivot && pivot < nums[j]) {
                swap(nums, i, j);
                i++;
                j--;
                // continue;
            }
            if (nums[i] >= pivot) {
                i++;
            }
            if (nums[j] <= pivot) {
                j--;
            }
        }
        swap(nums, left, j);
        return j;//pivot is now at jth index
    }

    private void quickSelect(int[] nums, int k, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = partition(nums, left, right);
        if (pivot == k) {
            ans = nums[pivot];
            return;
        }
        if (pivot > k) {
            // see on left
            quickSelect(nums, k, left, pivot - 1);
        } else {
            // see on right
            quickSelect(nums, k, pivot + 1, right);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        // using QuickSelect Algo
        int n = nums.length;
        quickSelect(nums, k-1, 0, n - 1);
        return ans;
    }
}
