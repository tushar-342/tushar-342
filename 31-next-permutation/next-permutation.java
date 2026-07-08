class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find pivot
        int gola_index = -1;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                gola_index = i - 1;
                break;
            }
        }

        // Step 2: Find next greater element
        if (gola_index != -1) {
            int swap_index = gola_index;

            for (int j = n - 1; j > gola_index; j--) {
                if (nums[j] > nums[gola_index]) {
                    swap_index = j;
                    break;
                }
            }

            int temp = nums[gola_index];
            nums[gola_index] = nums[swap_index];
            nums[swap_index] = temp;
        }

        // Step 3: Reverse suffix
        reverse(nums, gola_index + 1);
    }

    private void reverse(int[] nums, int left) {
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}