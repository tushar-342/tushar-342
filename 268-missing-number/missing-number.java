class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0, missingNumber=0, actualSum=0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            actualSum = n*(n+1)/2;
            missingNumber = Math.abs(sum-actualSum);
        }
        return missingNumber;
    }
}