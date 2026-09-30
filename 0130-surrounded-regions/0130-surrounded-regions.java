class Solution {
    private int rows;
    private int cols;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        rows = board.length;
        cols = board[0].length;

        // Process the first and last columns.
        for (int row = 0; row < rows; row++) {
            dfs(board, row, 0);
            dfs(board, row, cols - 1);
        }

        // Process the first and last rows.
        for (int col = 0; col < cols; col++) {
            dfs(board, 0, col);
            dfs(board, rows - 1, col);
        }

        // Capture surrounded regions and restore safe regions.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        // Out of bounds or not an unprocessed O.
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            board[row][col] != 'O') {
            return;
        }

        // Mark as safe because it is connected to the boundary.
        board[row][col] = '#';

        dfs(board, row - 1, col); // Up
        dfs(board, row + 1, col); // Down
        dfs(board, row, col - 1); // Left
        dfs(board, row, col + 1); // Right
    }
}