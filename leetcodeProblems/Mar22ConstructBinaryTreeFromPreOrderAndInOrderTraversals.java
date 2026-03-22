class Solution {
    int n;
    Map<Integer, Integer> mp;
    private TreeNode solve(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        int rootIdxInInorder = mp.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSubTreeElements = rootIdxInInorder - inStart;
        root.left = solve(preorder, preStart+1, preStart+leftSubTreeElements, inorder,inStart, rootIdxInInorder-1);
        root.right = solve(preorder, preStart+leftSubTreeElements+1, preEnd, inorder, rootIdxInInorder+1, inEnd);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n = preorder.length;
        mp = new HashMap<>();
        for(int i = 0;i < n;i++){
            mp.put(inorder[i], i);
        }
        // using recursion
        return solve(preorder, 0, n-1, inorder, 0, n-1);
    }
}
