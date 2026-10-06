class Solution {
    public int minAddToMakeValid(String s) {
        int openBracket = 0, extraCloseBracket = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                openBracket++;
            }else{
                if(openBracket > 0){
                    openBracket--;
                }else{
                    extraCloseBracket++;
                }
            }
        }
        return openBracket+extraCloseBracket;
    }
}