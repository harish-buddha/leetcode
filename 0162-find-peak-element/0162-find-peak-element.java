class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // We are on an increasing slope.
                // A peak must exist on the right.
                left = mid + 1;
            } else {
                // We are on a decreasing slope.
                // A peak exists at mid or on the left.
                right = mid;
            }
        }

        return left;
    }
}