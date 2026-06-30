class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int result = 0;
        int[] count = new int[3];
        int i=0, j=0;
        while(j < n){
            char ch = s.charAt(j);
            count[ch - 'a']++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                result += (n-j);

                count[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return result;
        
    }
}