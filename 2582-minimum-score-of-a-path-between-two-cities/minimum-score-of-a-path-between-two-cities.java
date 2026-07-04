class Solution {
    public int minScore(int n, int[][] roads) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];

            adj.get(u).add(new int[]{v, d});
            adj.get(v).add(new int[]{u, d});
        }

        boolean[] visited = new boolean[n + 1];
        int[] result = {Integer.MAX_VALUE};

        dfs(1, adj, visited, result);

        return result[0];
    }

   void dfs(int u, List<List<int[]>> adj, boolean[] visited, int[] result) {

        visited[u] = true;

        for (int[] p : adj.get(u)) {
            int v = p[0];
            int d = p[1];

            result[0] = Math.min(result[0], d);

            if (!visited[v]) {
                dfs(v, adj, visited, result);
            }
        }
    }
}