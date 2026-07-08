class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] nonZeroCount = new int[n];
        long[] numberUpTo = new long[n];
        long[] digitSumUpTo = new long[n];
        long[] pow10 = new long[n + 1];

        // Precompute powers of 10
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Initialize first character
        int firstDigit = s.charAt(0) - '0';
        nonZeroCount[0] = (firstDigit != 0) ? 1 : 0;
        numberUpTo[0] = (firstDigit != 0) ? firstDigit : 0;
        digitSumUpTo[0] = firstDigit;

        // Build prefix arrays
        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';

            // Prefix count of non-zero digits
            nonZeroCount[i] = nonZeroCount[i - 1] + (digit != 0 ? 1 : 0);

            // Number formed by concatenating non-zero digits
            if (digit != 0) {
                numberUpTo[i] = (numberUpTo[i - 1] * 10 + digit) % MOD;
            } else {
                numberUpTo[i] = numberUpTo[i - 1];
            }

            // Prefix digit sum
            digitSumUpTo[i] = digitSumUpTo[i - 1] + digit;
        }

        int q = queries.length;
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int startCount = (l == 0) ? 0 : nonZeroCount[l - 1];
            int endCount = nonZeroCount[r];

            int nonZeroDigits = endCount - startCount;

            // No non-zero digits in the substring
            if (nonZeroDigits == 0) {
                result[i] = 0;
                continue;
            }

            long numberBefore = (l == 0) ? 0 : numberUpTo[l - 1];

            long number = (numberUpTo[r]
                    - (numberBefore * pow10[nonZeroDigits]) % MOD
                    + MOD) % MOD;

            long digitSum = digitSumUpTo[r]
                    - ((l == 0) ? 0 : digitSumUpTo[l - 1]);

            result[i] = (int) ((number * digitSum) % MOD);
        }

        return result;
    }
}