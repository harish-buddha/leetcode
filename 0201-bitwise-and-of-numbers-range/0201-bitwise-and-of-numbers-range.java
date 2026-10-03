class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Remove bits from the right until both numbers
        // have the same binary prefix.
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        // Restore the common prefix to its original position.
        return left << shift;
    }
}