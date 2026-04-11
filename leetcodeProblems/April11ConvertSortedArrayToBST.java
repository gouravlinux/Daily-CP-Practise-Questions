/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int n;
    private TreeNode makeMiddleRootOfBST(int[] nums,int l,int r){
        if(l > r){
            return null;
        }
        int mid = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeMiddleRootOfBST(nums, l, mid-1);
        root.right = makeMiddleRootOfBST(nums, mid+1, r);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        // TC : O(n) for making every array's element a root node
        // SC : O(log n) 
        n = nums.length;
        return makeMiddleRootOfBST(nums, 0, n-1);
    }
}
