class Solution {
    public String minWindow(String s, String t) {
                if (s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];

        int required = 0;

        for (char ch : t.toCharArray()) {
            if (need[ch] == 0) {
                required++;
            }
            need[ch]++;
        }

        int formed = 0;

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);
            window[current]++;

            if (need[current] > 0 &&
                window[current] == need[current]) {
                formed++;
            }

            while (formed == required) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                if (need[leftChar] > 0 &&
                    window[leftChar] < need[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLength);
    }
}