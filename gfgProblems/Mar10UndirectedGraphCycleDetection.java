// using DFS
class Solution {
    boolean[] visited;
    private boolean hasCycleDFS(int i,int[][] edges,int parent){
        visited[i] = true;// mark it true
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(u != i && v != i){
                // this edge doesnot contain i vertex
                // therefore explore other edges
                continue;
            }
            // u or v is i
            int neighbour = (u == i)?v:u;
            if(neighbour == parent){
                continue;//don't revisit it: no cycle
            }
            if(visited[neighbour] == true){
                // if parent[neighbour] != i && visited[neighbour] == true
                return true;//cycle exists
            }
            // if parent[neighbour] != i && visited[neighbour] == false
            if (hasCycleDFS(neighbour, edges, i)){
                return true;   
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edge) {
        // Code here
        visited = new boolean[V];
        for(int i = 0;i < V;i++){
            if(!visited[i] && hasCycleDFS(i, edge, -1)){
                return true;
            }
        }
        return false;
    }
}
// using BFS
class Solution {
    boolean[] visited;
    private boolean hasCycleBFS(int i,int[][] edges){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,-1});
        visited[i] = true;// mark it true
        while(!que.isEmpty()){
            int[] item = que.poll();
            i = item[0];
            int parent = item[1];
            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                if(u != i && v != i){
                    // this edge doesnot contain i vertex
                    // therefore explore other edges
                    continue;
                }
                // u or v is i
                int neighbour = (u == i)?v:u;
                if(neighbour == parent){
                    continue;//don't revisit it: no cycle
                }
                if(visited[neighbour] == true){
                    // if parent[neighbour] != i && visited[neighbour] == true
                    return true;//cycle exists
                }
                // if parent[neighbour] != i && visited[neighbour] == false
                que.add(new int[]{neighbour, i});
                visited[neighbour] = true;
            }
        }
            
        
        return false;
    }
    public boolean isCycle(int V, int[][] edge) {
        // Code here
        visited = new boolean[V];
        for(int i = 0;i < V;i++){
            if(!visited[i] && hasCycleBFS(i, edge)){
                return true;
            }
        }
        return false;
    }
}
