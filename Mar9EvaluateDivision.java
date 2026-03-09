// using dfs 
class Node {
    String str;
    double val;

    Node(String str, double val) {
        this.str = str;
        this.val = val;
    }
}

class Solution {
    Map<String, List<Node>> adj;
    Set<String> visited;

    private double dfs(String u, String v, double product) {
        if (visited.contains(u)) {
            return -1;//u already visited
        }
        // mark u visited
        visited.add(u);
        if (u.equals(v)) {
            return product;
        }
        List<Node> neighbours = adj.get(u);
        for (Node adjNode : neighbours) {
            double res = dfs(adjNode.str, v, product * adjNode.val);
            if (res != -1)
                return res;
        }
        return -1;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // create an adjacency hash map
        adj = new HashMap<>();
        // since directed graph a/b = x and b/a = 1/x
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            // check if key exists or not
            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            if (!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }
            // add in list
            adj.get(u).add(new Node(v, val));
            adj.get(v).add(new Node(u, (double) (1 / val)));
        }
        double[] result = new double[queries.size()];
        int i = 0;
        // evaluate queries 
        for (List<String> query : queries) {
            String u = query.get(0);
            String v = query.get(1);
            if (!adj.containsKey(u) || !adj.containsKey(v)) {
                result[i++] = -1;
                continue;
            }
            visited = new HashSet<>();// for every query visited becomes fresh
            double res = dfs(u, v, 1);
            result[i++] = res;
        }
        return result;
    }
}
// using bfs
class Node {
    String str;
    double val;

    Node(String str, double val) {
        this.str = str;
        this.val = val;
    }
}

class Solution {
    Map<String, List<Node>> adj;
    Set<String> visited;

    private double bfs(String src, String dst) {
        Queue<Node> que = new LinkedList<>();
        if (visited.contains(src)) {
            return -1;//u already visited
        }
        // mark u visited
        visited.add(src);
        que.add(new Node(src, 1));
        if (src.equals(dst)) {
            return 1;
        }
        while (!que.isEmpty()) {
            Node srcNode = que.poll();
            String u = srcNode.str;
            double prod = srcNode.val;
            List<Node> neighbours = adj.get(u);
            for (Node adjNode : neighbours) {
                String v = adjNode.str;
                if (v.equals(dst)) {
                    return prod * adjNode.val;
                }
                if (visited.contains(v)) {
                    // already visited
                    continue;
                }
                // if not visited or not equals to v
                // push in que
                que.add(new Node(v, prod * adjNode.val));
                // add dst to visited
                visited.add(v);
            }
        }
        return -1;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // create an adjacency hash map
        adj = new HashMap<>();
        // since directed graph a/b = x and b/a = 1/x
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            // check if key exists or not
            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            if (!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }
            // add in list
            adj.get(u).add(new Node(v, val));
            adj.get(v).add(new Node(u, (double) (1 / val)));
        }
        double[] result = new double[queries.size()];
        int i = 0;
        // evaluate queries 
        for (List<String> query : queries) {
            String u = query.get(0);
            String v = query.get(1);
            if (!adj.containsKey(u) || !adj.containsKey(v)) {
                result[i++] = -1;
                continue;
            }
            visited = new HashSet<>();// for every query visited becomes fresh
            double res = bfs(u, v);
            result[i++] = res;
        }
        return result;
    }
}
