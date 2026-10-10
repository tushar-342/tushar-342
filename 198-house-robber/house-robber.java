class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        for(int i=0; i<=n; i++){
            java.util.Arrays.fill(dp[i], -1);
        }
        return fun(nums, n, 1, 0, dp);
    }
    int fun(int[] nums, int n, int free, int i, int[][] dp){
        if(i == n) return 0;
        if(dp[i][free] != -1) return dp[i][free];
        if(free == 0) return dp[i][free] = fun(nums, n, 1, i+1, dp);
        int take = nums[i] + fun(nums, n, 0, i+1, dp);
        int notTake = fun(nums, n , 1, i+1, dp);
        return dp[i][free] = Math.max(take, notTake);
    }
}