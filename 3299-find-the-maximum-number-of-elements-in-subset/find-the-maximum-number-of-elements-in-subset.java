import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Handle number 1 separately
        if (freq.containsKey(1L)) {
            int count = freq.get(1L);
            if (count % 2 == 0)
                ans = Math.max(ans, count - 1);
            else
                ans = Math.max(ans, count);
        }

        // Try every number as starting point
        for (long num : freq.keySet()) {
            if (num == 1L)
                continue;

            long x = num;
            int len = 0;

            while (freq.getOrDefault(x, 0) >= 2) {
                len += 2;

                // Prevent overflow
                if (x > 1_000_000_000L)
                    break;

                x = x * x;
            }

            if (freq.getOrDefault(x, 0) >= 1)
                len++;
            else
                len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}