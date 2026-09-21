class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][] dp = new int[n+1][k+1];
        //Already intialize your dp graph with 0 in java
        for(int i=n-1; i>=0; i--){
            //k==2 -> buy
            int c1 = dp[i+1][1]-prices[i]; //buy
            int c2 = dp[i+1][2]; //skip
            dp[i][2] = Math.max(c1,c2);

            //k == 1-> sell
            c1 = dp[i+1][0]+prices[i]; //sell
            c2 = dp[i+1][1];
            dp[i][1] = Math.max(c1,c2);
        }
        return dp[0][2];
    }
}