class Solution {

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome
            int oddLength = expandAroundCenter(s, i, i);

            // Even-length palindrome
            int evenLength = expandAroundCenter(s, i, i + 1);

            int maxLength = Math.max(oddLength, evenLength);

            if (maxLength > end - start + 1) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {

        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        // After the loop, left and right are one position
        // outside the palindrome.
        return right - left - 1;
    }
}