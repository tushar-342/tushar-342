class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> s = new HashSet<>();
        for(int n : nums){
            if(n % k == 0){
                s.add(n);
            }
        }
        int ans = k;
        while(s.contains(ans)){
            ans = ans + k;
        }
        return ans;
    }
}