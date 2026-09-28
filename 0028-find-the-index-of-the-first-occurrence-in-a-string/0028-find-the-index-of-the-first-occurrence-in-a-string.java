class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        int[] lps = buildLPS(needle);

        int i = 0; // haystack pointer
        int j = 0; // needle pointer

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    return i - m;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}