class Solution {
    private boolean inOrder(TreeNode curr, int targetSum, int currSum) {
        if(curr == null){
            return false;
        }
        currSum += curr.val;
        if(curr.left == null && curr.right == null){
            // a leaf node
            return targetSum == currSum;
        }
        
        // else
        // not a leaf node
	bool leftSide = inOrder(curr.left,targetSum,currSum);
	bool rightSide = inOrder(curr.right,targetSum,currSum);
        return leftSide || rightSide; 
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // using DFS: inOrder Traversal
        return inOrder(root, targetSum, 0);
    }
}
