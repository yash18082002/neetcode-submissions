class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
                int area = 0;
                while (!q.isEmpty()) {
                    int len = q.size();
                    for (int k = 0; k < len; k++) {
                        int[] curr = q.poll();
                        area++;
                        int row = curr[0];
                        int col = curr[1];
                        for (int[] dir : dirs) {
                            int nr = row + dir[0];
                            int nc = col + dir[1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 0 && visited[nr][nc] != true) {
                                q.add(new int[] {nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}
