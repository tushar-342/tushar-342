class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int cm = 0, officier = 1, res = 1;
        while(officier < n){
            if(nums[officier] == nums[officier - 1]){
                officier++;
                continue;
            }
            nums[cm + 1] = nums[officier];
            cm++;
            officier++;
            res++;
        }
        return res;
    }
}