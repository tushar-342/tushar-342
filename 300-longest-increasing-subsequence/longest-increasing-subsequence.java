class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n];
        for(int i=0; i<n; i++){
            java.util.Arrays.fill(dp[i], -1);
        }
        return fun(nums, 0, n, -1, dp);
    }
     int fun(int[] nums, int i, int n, int prev, int[][] dp){
        if(i==n) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        if(prev == -1 || nums[prev] < nums[i]) {
            int take = 1 + fun(nums, i+1, n, i, dp);
            int notTake = fun(nums, i+1, n, prev, dp);
            return dp[i][prev+1] = Math.max(take, notTake);
        }
        return dp[i][prev+1] = fun(nums, i+1, n, prev, dp);
     }
}