class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int nz = 0, z = 0;
        if(n == 0 || n ==1) return;
        while(nz < n){
            if(nums[nz] != 0){
                int temp = nums[nz];
                nums[nz] = nums[z];
                nums[z] = temp;
                nz++;
                z++; 
            }else{
                nz++;
            }
        }
    }
}