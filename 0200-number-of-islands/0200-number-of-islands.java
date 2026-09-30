class Solution {
     public int numIslands(char[][] grid) {
        int islands = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == '1') {
                    islands++;
                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        // Out of bounds or water.
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == '0') {
            return;
        }

        // Mark current land as visited.
        grid[row][col] = '0';

        // Explore four directions.
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }
}