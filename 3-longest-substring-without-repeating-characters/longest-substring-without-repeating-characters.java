class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        while(right < n){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                int lastIdx = map.get(ch);
                int newLeft = lastIdx+1;
            
            if(newLeft > left){
                left = newLeft;
            }
        }
            map.put(ch, right);
            int length = right-left+1;
             if(maxLength < length){
            maxLength = length;
        }
        right++;
          
        }        
      
        return maxLength;
    }
}