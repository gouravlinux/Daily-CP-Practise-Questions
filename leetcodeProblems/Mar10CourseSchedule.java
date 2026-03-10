class Solution {
    private int topoSort(int n, int[][] revEdges) {
        // using kahn's algo
        int[] indegree = new int[n];

        int nodeCnt = 0;
        // populate indegree
        for (int[] edge : revEdges) {
            int v = edge[0];
            indegree[v]++;
        }
        // Queue : have elements whose indegree is 0
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        while (!que.isEmpty()) {
            int vertex = que.poll();
            nodeCnt++;
            for (int[] edge : revEdges) {
                int u = edge[1];
                int v = edge[0];
                if (u != vertex)
                    continue;
                indegree[v]--;
                if (indegree[v] == 0)
                    que.add(v);
            }
        }
        return nodeCnt;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // cycle detection question
        // edges are reversely directed this time
        int nodeCnt = topoSort(numCourses, prerequisites);
        return nodeCnt == numCourses;
    }
}
