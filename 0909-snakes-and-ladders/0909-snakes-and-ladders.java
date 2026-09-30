class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[target + 1];

        queue.offer(1);
        visited[1] = true;

        int rolls = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all squares reachable with the current
            // number of dice rolls.
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == target) {
                    return rolls;
                }

                // Try every possible dice result.
                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;

                    if (next > target) {
                        break;
                    }

                    int[] position = getPosition(next, n);
                    int row = position[0];
                    int col = position[1];

                    // Take the snake or ladder exactly once.
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            rolls++;
        }

        return -1;
    }

    private int[] getPosition(int square, int n) {
        int rowFromBottom = (square - 1) / n;
        int col = (square - 1) % n;

        int row = n - 1 - rowFromBottom;

        // Every other row is reversed.
        if (rowFromBottom % 2 == 1) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}