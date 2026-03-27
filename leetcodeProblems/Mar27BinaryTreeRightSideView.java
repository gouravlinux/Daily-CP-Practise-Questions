class Solution {
    List<Integer> ans;
    private void preOrderTraversal(TreeNode root,int level){
        if(root == null) return;
	// if level is x and we not have x elements yet in list that does mean that 
	// we need to add this element first in ans for this current level(as we are ensuring that it is the rightmost element
        if(ans.size() < level) ans.add(root.val);//rightmost not taken so add 
        preOrderTraversal(root.right, level+1);//go right as we first need rightmost
        preOrderTraversal(root.left, level+1);// incase if right doesn't exist check left have rights or not or return left only
    }
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        preOrderTraversal(root, 1);// root, level
        return ans;
    }
}
