class Solution {
    public int maxProduct(int[] nums) {
        // int i = 0;
        int maxending = nums[0];
        int minending = nums[0];
        int ans = nums[0];
        for(int i=1; i<nums.length; i++){
            int v1 = nums[i];
            int v2 = maxending*nums[i];
            int v3 = minending*nums[i];
            maxending = Math.max(v1,Math.max(v2,v3));
            minending = Math.min(v1,Math.min(v2,v3));
            ans = Math.max(ans,Math.max(maxending,minending));
        }
        return ans;

        
    }
}