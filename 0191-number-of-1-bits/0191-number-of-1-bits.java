class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            // Remove the lowest set bit.
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}