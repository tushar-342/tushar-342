class Solution {
    int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> parse(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (i < s.length() && s.charAt(i) != '}') {

            if (s.charAt(i) == ',') {
                // Union
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                i++;
            }

            else if (s.charAt(i) == '{') {
                i++; // skip '{'

                Set<String> inside = parse(s);

                i++; // skip '}'

                // Concatenation
                Set<String> temp = new HashSet<>();

                for (String a : current) {
                    for (String b : inside) {
                        temp.add(a + b);
                    }
                }

                current = temp;
            }

            else {
                // Read word
                int start = i;

                while (i < s.length() && 
                       Character.isLetter(s.charAt(i))) {
                    i++;
                }

                String word = s.substring(start, i);

                Set<String> temp = new HashSet<>();

                for (String str : current) {
                    temp.add(str + word);
                }

                current = temp;
            }
        }

        // Add last term
        result.addAll(current);

        return result;
    }
}