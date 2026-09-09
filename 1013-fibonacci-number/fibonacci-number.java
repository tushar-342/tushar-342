class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibonnaci(n, dp);
    }
    private int fibonnaci(int n, int[] dp){
        if(n == 0 || n == 1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = fibonnaci(n-1, dp) + fibonnaci(n-2, dp);
        return dp[n];
    }
}