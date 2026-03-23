class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        // using BFS
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int levelSize = que.size();
            Node dummy = new Node();
            while(levelSize-- > 0){
                Node node = que.poll();
                dummy.next = node;
                dummy = dummy.next;
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            dummy.next = null;        
        }
        return root;     
    }
}
