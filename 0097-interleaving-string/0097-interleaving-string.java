class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        // Necessary condition: every character must be used.
        if (m + n != s3.length()) {
            return false;
        }

        // dp[j] means:
        // Can the processed prefix of s1 and first j characters of s2
        // form the corresponding prefix of s3?
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        // Base case: use only characters from s2.
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1]
                    && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Process characters from s1 one row at a time.
        for (int i = 1; i <= m; i++) {

            // j = 0 means we can only use s1.
            dp[0] = dp[0]
                    && s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                int k = i + j - 1;

                boolean takeFromS1 =
                        dp[j]
                        && s1.charAt(i - 1) == s3.charAt(k);

                boolean takeFromS2 =
                        dp[j - 1]
                        && s2.charAt(j - 1) == s3.charAt(k);

                dp[j] = takeFromS1 || takeFromS2;
            }
        }

        return dp[n];
    }
}