class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes.
        // Numbers ending in 0 are not palindromes unless the number is 0.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Reverse only half of the digits.
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // Even number of digits:
        // x == reversedHalf
        //
        // Odd number of digits:
        // Ignore the middle digit using reversedHalf / 10.
        return x == reversedHalf || x == reversedHalf / 10;
    }
}