class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftKnownSum = 0;
        int rightKnownSum = 0;

        int leftQuestionMark = 0;
        int rightQuestionMark = 0;

        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                if (i < n / 2) {
                    leftQuestionMark++;
                } else {
                    rightQuestionMark++;
                }
                }else{
                     if (i < n / 2) {
                     leftKnownSum += num.charAt(i) - '0';
                } else {
                    rightKnownSum += num.charAt(i) - '0';
                }
                }
            }

        int totalQuestionMarks = leftQuestionMark + rightQuestionMark;
        if(totalQuestionMarks % 2 != 0) {
            return true;
        }
        int LEFT = 2 * leftKnownSum + 9*leftQuestionMark;
        int RIGHT = 2 * rightKnownSum + 9*rightQuestionMark;
        if(LEFT == RIGHT){
            return false;
        }
        return true;


    }
}