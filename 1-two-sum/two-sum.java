import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
     HashMap<Integer,Integer> map = new HashMap<>();
     for(int i=0; i<nums.length; i++){
        int req_num = target - nums[i];
        if(map.containsKey(req_num)){
            return new int[]{map.get(req_num), i};
        }
        map.put(nums[i], i);
     }
     return new int[]{};
    }
}