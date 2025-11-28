class Solution {
    int k;
    int result;
    List<List<Integer>> graph;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.result = 0;
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        dfs(0, -1, values);
        return result;
    }
    private int dfs(int node, int parent, int[] values) {
        long sum = values[node];

        for (int next : graph.get(node)) {
            if (next == parent) continue;
            sum += dfs(next, node, values);
        }

        if (sum % k == 0) {
            result++;
            return 0;
        }
        return (int) (sum % k);
    }
}
