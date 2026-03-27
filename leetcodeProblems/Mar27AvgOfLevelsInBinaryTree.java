class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // O(N) TC and SC
        List<Double> avgOfLevelsList = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            double avg = 0;
            int levelSize = que.size();
            int n = levelSize;
            while(n-- > 0){
                TreeNode node = que.poll();
                avg+=node.val;
                if(node.left != null)que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            avg = avg/levelSize;
            avgOfLevelsList.add(avg);
        }
        return avgOfLevelsList;
    }
}
