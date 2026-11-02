import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        int median = quickSelect(nums, 0, n - 1, n / 2);

        int movesCount = 0;

        for(int i = 0; i < n; i++){
            movesCount += Math.abs(nums[i] - median);
        }

        return movesCount;
    }

    int quickSelect(int[] nums, int left, int right, int k) {

        int pivot = nums[right];
        int p = left;

        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }

        int temp = nums[p];
        nums[p] = nums[right];
        nums[right] = temp;

        if(p == k){
            return nums[p];
        }
        else if(p < k){
            return quickSelect(nums, p + 1, right, k);
        }
        else{
            return quickSelect(nums, left, p - 1, k);
        }
    }
}