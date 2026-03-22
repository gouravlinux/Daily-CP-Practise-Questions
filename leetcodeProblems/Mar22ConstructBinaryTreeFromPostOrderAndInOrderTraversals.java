class Solution {
    int n;
    Map<Integer, Integer> mp;
    private TreeNode solve(int[] inorder, int inStart,int inEnd,int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootInInOrder = mp.get(rootVal);
        int leftSubTreeElements = rootInInOrder - inStart;
        root.left = solve(inorder, inStart, rootInInOrder-1, postorder, postStart, postStart+leftSubTreeElements-1);
        root.right = solve(inorder, rootInInOrder+1, inEnd, postorder, postStart+leftSubTreeElements, postEnd-1);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        n = inorder.length;
        mp = new HashMap<>();
        for(int i = 0;i < n;i++){
            mp.put(inorder[i], i);
        }
        return solve(inorder, 0, n-1, postorder, 0, n-1);
    }
}
