class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int prev_prev = 0; // dp[0]
        int prev = 1; //dp[1];
        int ans = 0;
        for(int i=2; i<=n; i++){
            ans = prev_prev + prev;
            prev_prev = prev;
            prev = ans;
        }
        return ans;
    }
}