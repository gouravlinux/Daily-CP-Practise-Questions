/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // stores purana node mapped to naya node, so that if that node appears again we will not make it again
    Map<Node, Node> mp;
    private void dfs(Node node, Node clonedNode){
        for(Node n: node.neighbors){
            if(!mp.containsKey(n)){
                // no cloned node made for node n
                Node clone = new Node(n.val);
                mp.put(n, clone);
                // add to its neigbors list
                clonedNode.neighbors.add(clone);
                dfs(n, clone);
            }
            else{
                // a cloned node is present
                // add it to neighbors list
                clonedNode.neighbors.add(mp.get(n));
                // no need to make DFS on that (already visited)
            }
        }
    }
    public Node cloneGraph(Node node) {
        mp = new HashMap<>();
        if(node == null) return null;
        // clone the given node
        Node clonedNode = new Node(node.val);
        mp.put(node, clonedNode);
        dfs(node, clonedNode);
        return clonedNode;
    }
}

class Solution {
    // stores purana node mapped to naya node, so that if that node appears again we will not make it again
    Map<Node, Node> mp;

    private void bfs(Node node) {
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        while (!que.isEmpty()) {
            Node item = que.poll();
            Node clonedNode = mp.get(item);
            for (Node n : item.neighbors) {
                if (!mp.containsKey(n)) {
                    // no cloned node made for node n
                    Node clone = new Node(n.val);
                    mp.put(n, clone);
                    // add to its neigbors list
                    clonedNode.neighbors.add(clone);
                    que.add(n);
                } else {
                    // a cloned node is present
                    // add it to neighbors list
                    clonedNode.neighbors.add(mp.get(n));
                    // no need to make BFS on that (already visited)
                }
            }
        }
    }

    public Node cloneGraph(Node node) {
        mp = new HashMap<>();
        if (node == null)
            return null;
        // clone the given node
        Node clonedNode = new Node(node.val);
        mp.put(node, clonedNode);
        bfs(node);
        return clonedNode;
    }
}
