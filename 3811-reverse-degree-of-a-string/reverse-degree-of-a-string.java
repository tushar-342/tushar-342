class Solution {
    public int reverseDegree(String s) {
        int i=1, sum = 0;
        for(char ch : s.toCharArray()){
            int rev = 'z' - ch + 1;
            sum += rev*i;
            i++;
            
        }
        return sum;
    }
}