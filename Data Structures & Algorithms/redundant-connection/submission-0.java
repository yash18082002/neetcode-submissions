class Solution {
    int[] parent, size;

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return false;
        if (size[rx] < size[ry]) {
            int temp = rx;
            rx = ry;
            ry = temp;
        }
        parent[ry] = rx;
        size[rx] += size[ry];
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) return edge;
        }
        return new int[0];
    }
}
