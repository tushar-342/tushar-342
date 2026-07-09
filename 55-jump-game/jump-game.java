class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastIdx = nums.length - 1;
        for(int i = n - 2; i >= 0; i--) {
            if(i + nums[i] >= lastIdx) {
                lastIdx = i;
            }
        }
        return lastIdx == 0;
    }
}