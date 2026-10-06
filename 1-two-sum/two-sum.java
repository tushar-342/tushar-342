class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int reqNum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            reqNum = target - nums[i];
            if(map.containsKey(reqNum)){
                return new int[] {map.get(reqNum), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}