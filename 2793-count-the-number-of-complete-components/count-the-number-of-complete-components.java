class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int nodes;
    int edges;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                nodes = 0;
                this.edges = 0;

                dfs(i);

                this.edges /= 2; // Each edge counted twice

                if (this.edges == nodes * (nodes - 1) / 2) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfs(int node) {
        visited[node] = true;
        nodes++;

        edges += graph[node].size();

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}