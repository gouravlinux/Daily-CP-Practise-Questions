// using DFS
class Solution {
    Stack<Integer> stack;
    boolean[] visited;
    private void dfs(int i,int[][] edges){
        visited[i] = true;
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(u != i){
                continue;//not that edge
            }
            // if u == i
            if(!visited[v])
                dfs(v, edges);//pehle mere neighbours ko daalo
        }
        stack.push(i);//fir mujhe daalo
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        stack = new Stack<>();
        visited = new boolean[V];
        for(int i = 0;i < V;i++){
            if(!visited[i])
                dfs(i, edges);
        }
        ArrayList<Integer> ls = new ArrayList<>();
        while(!stack.isEmpty()){
            ls.add(stack.pop());
        }
        return ls;
    }
}
// using BFS (Kahn's Algo)
class Solution {
    int[] indegree;
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        // using Kahn's (BFS) Algo
        ArrayList<Integer> res = new ArrayList<>();
        indegree = new int[V];
        // indegrees are filled first
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            indegree[v]++;
        }
        // now do BFS
        // for that vertices having indegree 0 would be pushed in queue
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i < V;i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int i = que.poll();
            res.add(i);
            for(int[] edge:edges){
                int u = edge[0];
                int v = edge[1];
                if(u != i) continue;
                indegree[v]--;
                if(indegree[v] == 0){
                    que.add(v);//only add to que if indegree is 0
                }
            }
        }
        return res;
    }
}
