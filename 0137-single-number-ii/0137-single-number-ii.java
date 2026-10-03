class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Process all 32 bits of an integer.
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            // Count how many numbers have this bit set.
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Bits appearing a multiple of 3 times belong
            // to numbers that occur three times.
            if (count % 3 != 0) {
                result |= (1 << bit);
            }
        }

        return result;
    }
}