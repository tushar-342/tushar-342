class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low = 0, high = 0, res = Integer.MAX_VALUE, sum = 0;
        while(high < n){
            sum += nums[high];
            while(sum >= target){
                int leng = high - low + 1;
                res = Math.min(res, leng);
                sum -= nums[low];
                low++;
            }
            high++;
        }
        if(res == Integer.MAX_VALUE) return 0;
        return res;
    }
}