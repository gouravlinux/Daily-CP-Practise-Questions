class Solution {
    public int maxDepth(TreeNode root) {
        // using DFS
        if(root == null){
            return 0;
        }
        int leftSubTreeMaxDepth = maxDepth(root.left);
        int rightSubTreeMaxDepth = maxDepth(root.right);
        int maximumDepth = 1 + Math.max(leftSubTreeMaxDepth, rightSubTreeMaxDepth);
        return maximumDepth;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        // using BFS
        if(root == null){
            return 0;
        }
        int levels = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int levelSize = que.size();
            while(levelSize-- > 0){
                TreeNode node = que.poll();
                if(node.left != null)
                    que.add(node.left);
                if(node.right != null)
                    que.add(node.right);
            }
            levels++;
        }
        return levels;
    }
}
