class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {

            // End of the current range
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                int end = nums[i - 1];

                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }

                // Start a new range
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }
}