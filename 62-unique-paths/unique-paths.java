class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            java.util.Arrays.fill(dp[i], -1);
        }
        return fun(n,m,0,0,dp);
    }
    int fun(int n, int m, int i, int j, int[][] dp){
        if(i<0 || i>=n || j<0 || j>=m) return dp[i][j] = 0;
        if(i==n-1 || j==m-1) return 1;
        if (dp[i][j] != -1) return dp[i][j]; 
        return dp[i][j] = fun(n,m,i+1,j,dp) + fun(n,m,i,j+1,dp) ;
    }
   
}