class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", res, phone);

        return res;
    }

    public void backtrack(String digits, int index, String current,
                           List<String> res, String[] phone) {

        if (index == digits.length()) {
            res.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';

        String letters = phone[digit];

        for (char ch : letters.toCharArray()) {
            backtrack(digits, index + 1, current + ch, res, phone);
        }
    }
}