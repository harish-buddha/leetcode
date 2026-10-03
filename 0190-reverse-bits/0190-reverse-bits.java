class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit.
            int bit = n & 1;

            // Shift result left and append the extracted bit.
            result = (result << 1) | bit;

            // Logical right shift to process the next bit.
            n >>>= 1;
        }

        return result;
    }
}