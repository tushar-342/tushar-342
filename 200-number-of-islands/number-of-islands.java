class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, rows, cols, i, j, visited);
                    res++;
                }
            }
        }
          return res;
    }
    
    boolean valid(int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }
    void dfs(char[][] grid, int n, int m, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        for(int k=0; k<4; k++){
            int row = i+x[k];
            int col = j+y[k];
            if(valid(row, col, n, m) && grid[row][col] == '1' && !visited[row][col]){
                dfs(grid, n, m, row, col, visited);
            }
        }
    }
}