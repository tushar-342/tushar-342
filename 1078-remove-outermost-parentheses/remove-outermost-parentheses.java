class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        String res = "";
        int count = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                if(count != 0){
                    res += s.charAt(i);
                }
                count++;
            }else{
                count--;
                if(count != 0){
                    res += s.charAt(i);
                }
            }
        }
        return res;
    }
}