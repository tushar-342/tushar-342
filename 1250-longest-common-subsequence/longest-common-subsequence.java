class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            java.util.Arrays.fill(dp[i], -1);
        }
        return fun(text1, text2, n, m, 0, 0, dp);
    }
    int fun(String text1, String text2, int n, int m, int i, int j, int[][] dp){
        if(i==n || j==m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) return dp[i][j] = 1 + fun(text1, text2, n, m, i+1, j+1, dp);
        int c1 = fun(text1, text2, n, m, i, j+1, dp);
        int c2 = fun(text1, text2, n, m, i+1, j, dp);
        return dp[i][j] = Math.max(c1, c2);
    }
}