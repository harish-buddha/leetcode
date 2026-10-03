class Solution {
    public int[] plusOne(int[] digits) {
        // Start from the least significant digit.
        for (int i = digits.length - 1; i >= 0; i--) {

            // If the digit is less than 9, simply increment it.
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // 9 + 1 = 10, so this digit becomes 0
            // and the carry moves to the left.
            digits[i] = 0;
        }

        // If we reach here, every digit was 9.
        // Example: [9,9,9] -> [1,0,0,0]
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}