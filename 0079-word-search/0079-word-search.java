class Solution {

    private int rows;
    private int cols;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;

        // Try every cell as a possible starting point.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, int index) {
        // All characters have been matched.
        if (index == word.length()) {
            return true;
        }

        // Boundary check.
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols) {
            return false;
        }

        // Character mismatch or cell already used.
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark this cell as visited.
        char original = board[row][col];
        board[row][col] = '#';

        // Explore four directions.
        boolean found =
                dfs(row + 1, col, index + 1) ||
                dfs(row - 1, col, index + 1) ||
                dfs(row, col + 1, index + 1) ||
                dfs(row, col - 1, index + 1);

        // Backtrack: restore the original character.
        board[row][col] = original;

        return found;
    }
}