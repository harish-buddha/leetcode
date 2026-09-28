class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // {sum, index in nums1, index in nums2}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Initialize with first element from each row
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {

            int[] current = minHeap.poll();
            int row = current[1];
            int col = current[2];

            result.add(Arrays.asList(nums1[row], nums2[col]));
            k--;

            // Push next column in same row
            if (col + 1 < nums2.length) {
                minHeap.offer(new int[]{
                    nums1[row] + nums2[col + 1],
                    row,
                    col + 1
                });
            }
        }

        return result;
    }
}