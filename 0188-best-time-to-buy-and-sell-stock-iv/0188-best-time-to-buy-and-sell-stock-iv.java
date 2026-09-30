class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // At most n / 2 transactions can actually be completed.
        if (k >= n / 2) {
            int profit = 0;

            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        // Initially, buying a stock gives negative profit.
        for (int t = 1; t <= k; t++) {
            buy[t] = Integer.MIN_VALUE / 2;
        }

        for (int price : prices) {

            // Process transactions in reverse order.
            for (int t = k; t >= 1; t--) {

                // Sell the stock and complete transaction t.
                sell[t] = Math.max(
                    sell[t],
                    buy[t] + price
                );

                // Buy the stock for transaction t.
                buy[t] = Math.max(
                    buy[t],
                    sell[t - 1] - price
                );
            }
        }

        return sell[k];
    }
}