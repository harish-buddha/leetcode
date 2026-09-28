class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Pair each project: {requiredCapital, profit}
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort by required capital
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        // Max heap stores profits
        PriorityQueue<Integer> maxProfit =
                new PriorityQueue<>(Collections.reverseOrder());

        int index = 0;

        for (int round = 0; round < k; round++) {

            // Add every affordable project
            while (index < n && projects[index][0] <= w) {
                maxProfit.offer(projects[index][1]);
                index++;
            }

            // No project can be started
            if (maxProfit.isEmpty()) {
                break;
            }

            // Choose the most profitable one
            w += maxProfit.poll();
        }

        return w;
    }
}