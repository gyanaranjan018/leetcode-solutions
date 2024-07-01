class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, 1, 0, -1};

        boolean[][] vis = new boolean[n][m];

        for(int row = 0; row < n; row++){
            if(!vis[row][0] && grid[row][0] == 1){
                dfs(row, 0, vis, grid, n, m, delRow, delCol);
            }
            if(!vis[row][m-1] && grid[row][m-1] == 1){
                dfs(row, m-1, vis, grid, n, m, delRow, delCol);
            }
        }

        for(int col = 0; col < m; col++){
            if(!vis[0][col] && grid[0][col] == 1){
                dfs(0, col, vis, grid, n, m, delRow, delCol);
            }
            if(!vis[n-1][col] && grid[n-1][col] == 1){
                dfs(n-1, col, vis, grid, n, m, delRow, delCol);
            }
        }

        int count =0;

        for(int i =0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, boolean[][] vis, int[][] grid, int n, int m, int[] delRow, int[] delCol){
        vis[row][col] = true;

        for(int i =0; i< 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, vis, grid, n, m, delRow, delCol);
            }
        }

        return;
    }
}