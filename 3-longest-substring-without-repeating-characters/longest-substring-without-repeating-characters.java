class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0, left = 0, maxLeng = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                int lastIdx = map.get(ch);
                int newLeft = lastIdx + 1;
                 if(newLeft > left){
                left = newLeft;
            }
            }
            map.put(ch, right);
          
            int currLeng = right - left + 1;
            if(currLeng > maxLeng){
                maxLeng = currLeng;
            }
            right++;
        }
        return maxLeng;
    }
}