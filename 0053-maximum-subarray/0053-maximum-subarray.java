class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start fresh.
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Track the best subarray sum seen so far.
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}