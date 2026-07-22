class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
                }
            }
        }
            return maxArea;
        }
        int dfs(int[][] grid, int row, int col, boolean[][] visited){
            if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]){
                return 0;
            }
            visited[row][col] = true;
            int area = 1;
            for(int k=0; k<4; k++){
                area += dfs(grid, row + x[k], col + y[k], visited);
            }
             return area;
        }
    }
