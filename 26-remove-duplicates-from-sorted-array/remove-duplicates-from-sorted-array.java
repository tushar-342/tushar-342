class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int res = 1;
        int j = 1;

        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
                continue;
            }
            //continue

            nums[i+1] = nums[j];
            i++;
            j++;
            res++;
        }

        return res;
    }
}