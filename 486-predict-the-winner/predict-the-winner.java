import java.util.Arrays;

class Solution {

    int solve(int i, int j, int[] nums, int[][] dp) {

        if (i > j)
            return 0;

        if (i == j)
            return nums[i];

        if (dp[i][j] != -1)
            return dp[i][j];

        int takeI = nums[i] + Math.min(
                solve(i + 2, j, nums, dp),
                solve(i + 1, j - 1, nums, dp)
        );

        int takeJ = nums[j] + Math.min(
                solve(i + 1, j - 1, nums, dp),
                solve(i, j - 2, nums, dp)
        );

        return dp[i][j] = Math.max(takeI, takeJ);
    }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int player1 = solve(0, n - 1, nums, dp);

        int total = 0;
        for (int x : nums)
            total += x;

        return player1 >= total - player1;
    }
}