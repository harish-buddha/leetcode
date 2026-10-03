class Solution {

    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] mainDiagonals = new boolean[2 * n - 1];
        boolean[] antiDiagonals = new boolean[2 * n - 1];

        backtrack(0, n, columns, mainDiagonals, antiDiagonals);

        return count;
    }

    private void backtrack(
            int row,
            int n,
            boolean[] columns,
            boolean[] mainDiagonals,
            boolean[] antiDiagonals) {

        // All rows have a valid queen placement.
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            int mainDiagonal = row - col + n - 1;
            int antiDiagonal = row + col;

            // Check whether this position is safe.
            if (columns[col]
                    || mainDiagonals[mainDiagonal]
                    || antiDiagonals[antiDiagonal]) {
                continue;
            }

            // Place the queen.
            columns[col] = true;
            mainDiagonals[mainDiagonal] = true;
            antiDiagonals[antiDiagonal] = true;

            backtrack(
                    row + 1,
                    n,
                    columns,
                    mainDiagonals,
                    antiDiagonals
            );

            // Backtrack: remove the queen.
            columns[col] = false;
            mainDiagonals[mainDiagonal] = false;
            antiDiagonals[antiDiagonal] = false;
        }
    }
}