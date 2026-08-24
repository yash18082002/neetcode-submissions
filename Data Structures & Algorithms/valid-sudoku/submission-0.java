class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                Set<Character> rowSet = rows[i];
                Set<Character> colSet = cols[j];
                Set<Character> boxSet = boxes[3 * (i / 3) + (j / 3)];

                if (rowSet.contains(c) || colSet.contains(c) || boxSet.contains(c)) {
                    return false;
                }
                rowSet.add(c);
                colSet.add(c);
                boxSet.add(c);
            }
        }

        return true;
    }
}
