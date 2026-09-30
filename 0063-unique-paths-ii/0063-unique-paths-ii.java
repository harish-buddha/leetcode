class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // dp[j] = number of ways to reach column j
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // An obstacle cannot be part of any valid path.
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    // dp[j] = ways from above + ways from left
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}