class Solution {

    private static final int[][] DIRECTIONS = {
        {-1,-1}, {-1,0}, {-1,1},
        {0,-1},          {0,1},
        {1,-1},  {1,0},  {1,1}
    };

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // First pass: mark transitions
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int liveNeighbors = countLiveNeighbors(board, row, col);

                if (board[row][col] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[row][col] = -1; // Live -> Dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[row][col] = 2;  // Dead -> Live
                    }
                }
            }
        }

        // Second pass: finalize values
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0;
                } else if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int live = 0;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < board.length &&
                newCol >= 0 && newCol < board[0].length) {

                if (board[newRow][newCol] == 1 ||
                    board[newRow][newCol] == -1) {
                    live++;
                }
            }
        }

        return live;
    }
}