class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int missingNumber = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];
            int actualSum = n*(n+1)/2;
             missingNumber = actualSum - sum;
        }
        return missingNumber;
    }
}