class Solution {
    private boolean[][] bfs(int[][] heights, boolean[][] visited, int m, int n, Queue<int[]> q) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : dirs) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && heights[nr][nc] >= heights[row][col] && visited[nr][nc] == false) {
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
        }
        return visited;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            pq.add(new int[] {i, 0});
            pacific[i][0] = true;
            aq.add(new int[] {i, n - 1});
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pq.add(new int[] {0, j});
            pacific[0][j] = true;
            aq.add(new int[] {m - 1, j});
            atlantic[m - 1][j] = true;
        }

        pacific = bfs(heights, pacific, m, n, pq);
        atlantic = bfs(heights, atlantic, m, n, aq);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
