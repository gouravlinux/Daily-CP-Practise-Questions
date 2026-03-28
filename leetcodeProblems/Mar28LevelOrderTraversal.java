class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversalList = new ArrayList<>();
        if(root == null) return levelOrderTraversalList;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int n = que.size();
            List<Integer> list = new ArrayList<>();
            while(n-- > 0){
                TreeNode node = que.poll();
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
                list.add(node.val);
            }
            levelOrderTraversalList.add(list);
        } 
        return levelOrderTraversalList;
    }
}
