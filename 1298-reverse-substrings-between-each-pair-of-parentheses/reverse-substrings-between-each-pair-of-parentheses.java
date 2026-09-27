class Solution {
    public String reverseParentheses(String s) {

        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(current.toString());
                current.setLength(0);
            }
            else if(ch == ')'){
                current.reverse();
                current.insert(0, stack.pop());
            }
            else{
                current.append(ch);
            }
        }

        return current.toString();
    }
}