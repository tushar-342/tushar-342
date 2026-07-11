class Solution {

    int[][] dp;

    public String longestPalindrome(String s) {

        int n = s.length();

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxLen = 0;
        int sp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (solve(s, i, j)) {

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp + maxLen);
    }

    boolean solve(String s, int i, int j) {

        if (i >= j)
            return true;

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        if (s.charAt(i) == s.charAt(j) && solve(s, i + 1, j - 1)) {
            dp[i][j] = 1;
            return true;
        }

        dp[i][j] = 0;
        return false;
    }
}