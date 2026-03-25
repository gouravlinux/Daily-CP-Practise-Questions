class Solution {
    int num = 0;
    int ans = 0;
    private void inOrder(TreeNode root) {
        if(root == null) return;
        num = num*10 + root.val;
        if(root.left == null && root.right == null){
            // leaf node
            ans += num;
            num = (int)num/10;// backtrack
            return;
        }
        // else 
        // not a leaf node
        inOrder(root.left);
        inOrder(root.right);
        num = (int)num/10;// backtrack
    }
    public int sumNumbers(TreeNode root) {
        inOrder(root);
        return ans;
    }
}
