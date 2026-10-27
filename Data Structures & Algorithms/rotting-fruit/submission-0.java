class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if (grid[i][j] == 1) fresh++;
            }
        }

        if (q.isEmpty() && fresh > 0) return -1;
        
        int mins = 0;
        while (!q.isEmpty() && fresh > 0) {
            int len = q.size();
            mins++;
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
        }
        return fresh == 0 ? mins : -1;
    }
}
