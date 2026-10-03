class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search the smaller array.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        // Number of elements that should be on the left side.
        int half = (m + n + 1) / 2;

        while (low <= high) {

            int partition1 = low + (high - low) / 2;
            int partition2 = half - partition1;

            // Boundary values around partition1.
            int left1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int right1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            // Boundary values around partition2.
            int left2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int right2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            // Correct partition found.
            if (left1 <= right2 && left2 <= right1) {

                // Odd total number of elements.
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even total number of elements.
                int leftMax = Math.max(left1, left2);
                int rightMin = Math.min(right1, right2);

                return ((double) leftMax + rightMin) / 2.0;
            }

            // Too many elements taken from nums1.
            if (left1 > right2) {
                high = partition1 - 1;
            }

            // Too few elements taken from nums1.
            else {
                low = partition1 + 1;
            }
        }

        // Input arrays are guaranteed to be valid and sorted.
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}