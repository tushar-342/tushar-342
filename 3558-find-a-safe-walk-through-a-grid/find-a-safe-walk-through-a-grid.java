import java.util.*;

class Solution {

    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] result = new int[m][n];

        // Initialize with a large value
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        Deque<int[]> deq = new LinkedList<>();

        // Source
        result[0][0] = grid.get(0).get(0);
        deq.offerFirst(new int[]{0, 0});

        while (!deq.isEmpty()) {

            int[] curr = deq.pollFirst();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (result[r][c] + grid.get(nr).get(nc) < result[nr][nc]) {

                    result[nr][nc] = result[r][c] + grid.get(nr).get(nc);

                    if (grid.get(nr).get(nc) == 0) {
                        deq.offerFirst(new int[]{nr, nc});
                    } else {
                        deq.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }

        int x = result[m - 1][n - 1];

        return health - x >= 1;
    }
}