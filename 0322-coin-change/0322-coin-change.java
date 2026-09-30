class Solution {
    public int coinChange(int[] coins, int amount) {
          // dp[x] = minimum number of coins needed to make amount x
        int[] dp = new int[amount + 1];

        // amount + 1 acts as infinity
        int impossible = amount + 1;

        for (int i = 1; i <= amount; i++) {
            dp[i] = impossible;
        }

        // Base case: zero coins are needed to make amount 0
        dp[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (coin <= currentAmount) {
                    dp[currentAmount] = Math.min(
                        dp[currentAmount],
                        dp[currentAmount - coin] + 1
                    );
                }
            }
        }

        return dp[amount] == impossible ? -1 : dp[amount];
    }
}