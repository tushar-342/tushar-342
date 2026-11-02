class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int minElement = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minElement = Math.min(minElement, nums[i]);
        }
        int movesCount = 0;
        for(int i=0; i<n; i++){
            movesCount += nums[i] - minElement;
        }
        return movesCount;
    }
}