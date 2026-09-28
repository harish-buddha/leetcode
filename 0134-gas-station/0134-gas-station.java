class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalBalance = 0;
        int currentTank = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];

            totalBalance += diff;
            currentTank += diff;

            // Current start cannot reach next station
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }

        return totalBalance >= 0 ? startStation : -1;
    }
}