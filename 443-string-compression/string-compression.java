class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int i = 0;
        int index = 0;

        while (i < n) {

            char curr_char = chars[i];
            int count = 0;

            // Find count of duplicate characters
            while (i < n && chars[i] == curr_char) {
                count++;
                i++;
            }

            // Assign current character
            chars[index] = curr_char;
            index++;

            // Assign count if greater than 1
            if (count > 1) {

                String count_str = String.valueOf(count);

                for (char ch : count_str.toCharArray()) {
                    chars[index] = ch;
                    index++;
                }
            }
        }

        return index;
    }
}