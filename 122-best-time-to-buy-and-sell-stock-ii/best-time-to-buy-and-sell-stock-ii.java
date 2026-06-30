class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
        int k=2;
        int[][] dp = new int[n+1][k+1];
        for(int i=0; i<n; i++){
            java.util.Arrays.fill(dp[i], -1);
        }
        return fun(prices, 0, n, k, dp);
    }
    int fun(int[] prices, int i, int n, int k, int[][] dp){
        if(i==n || k==0) return 0;
        if(dp[i][k] != -1) return dp[i][k];
        if(k==2){ //buy
            int c1 = fun(prices, i+1, n, k-1, dp) - prices[i];
            int c2 = fun(prices, i+1, n, k, dp);
            return dp[i][k] = Math.max(c1, c2);
        }else{  //k==1 => sell
            int c1 = fun(prices, i+1, n, 2, dp) + prices[i];
            int c2 = fun(prices, i+1, n, k, dp);
            return dp[i][k] = Math.max(c1, c2);
        }
        
    }
}