class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0, left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            char currChar = s.charAt(right);
            if(map.containsKey(currChar)){
                int lastIdx = map.get(currChar);
                int newLeft = lastIdx+1;
                if(newLeft > left){
                    left = newLeft;
                }
            }
            map.put(currChar, right);
            int currWindow = right - left + 1;
            if(currWindow > maxLength){
                maxLength = currWindow;
            }
            right++;
        }
        return maxLength;
    }
}