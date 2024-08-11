class Solution {
    int[][] dir = {{-1, 0}, {0,1}, {1, 0}, {0, -1}};
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int islands = NumberOfIslands(grid, m, n);

        if(islands == 0 || islands > 1){
            return 0;
        }

        for(int i =0; i< m; i++){
            for(int j =0; j< n; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    islands = NumberOfIslands(grid, m, n);
                    if(islands == 0 || islands > 1){
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public int NumberOfIslands(int[][] matrix, int m, int n){
        int region = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i =0; i< m; i++){
            for(int j =0; j< n; j++){
                if(matrix[i][j] == 1 && !vis[i][j]){
                    dfs(matrix, vis , i, j, m, n);
                    region++;
                }
            }
        }
        return region;
    }

    public void dfs(int[][] matrix, boolean[][] vis, int i, int j, int m, int n){
        if(i < 0 || i >= m || j <0 || j>= n || matrix[i][j] == 0 || vis[i][j]){
            return;
        }

        vis[i][j] = true;

        for(int k = 0; k < 4; k++){
            int new_i = i + dir[k][0];
            int new_j = j + dir[k][1];
            dfs(matrix, vis, new_i, new_j, m, n);
        }
    }
}