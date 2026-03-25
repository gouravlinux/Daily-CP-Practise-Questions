class Solution {
    List<List<Integer>> nodeList = new ArrayList<>();
    List<Integer> targetList = new ArrayList<>();

    private void inOrder(TreeNode currNode, int targetSum, int currSum) {
        if (currNode == null)
            return;
        currSum += currNode.val;
        targetList.add(currNode.val);
        if (currNode.left == null && currNode.right == null) {
            // a leaf node
            if (currSum == targetSum) {
                nodeList.add(new ArrayList<>(targetList));
            }
            targetList.remove(targetList.size() - 1);//backtrack
            return;
        }
        // else
        // if not a leaf node
        // explore both sides 
        inOrder(currNode.left, targetSum, currSum);
        inOrder(currNode.right, targetSum, currSum);
        targetList.remove(targetList.size() - 1);//backtrack
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // using backtracking
        inOrder(root, targetSum, 0);
        return nodeList;
    }
}
