class Solution {
    int m, n;
    private void dfs (char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        board[i][j] = 'Y';
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            dfs(board, newI, newJ);
        }
    }
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        if (m == 1 || n == 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
}
