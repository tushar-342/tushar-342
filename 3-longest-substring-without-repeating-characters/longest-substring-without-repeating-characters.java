class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int right = 0, left = 0, maxLeng = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            int newLeft = left;
            if(map.containsKey(ch)){
                int lastIdx = map.get(ch);
                newLeft = lastIdx + 1;
            }
            if(newLeft > left){
                left = newLeft;
            }
            map.put(ch, right);

            int currLeng = right - left + 1;
            maxLeng = Math.max(currLeng, maxLeng);
            right++;
        }
        return maxLeng;
    }
}