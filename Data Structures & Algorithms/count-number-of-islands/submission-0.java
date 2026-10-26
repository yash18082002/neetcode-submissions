class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs (int row, int col, char[][] grid, boolean[][] visited, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0'|| visited[row][col] == true) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(nr, nc, grid, visited, m, n);
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    dfs(i, j, grid, visited, m, n);
                    islands++;
                }
            }
        }
        return islands;
    }
}
