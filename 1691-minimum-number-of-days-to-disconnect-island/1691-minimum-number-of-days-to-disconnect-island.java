class Solution {
    int[][] dir = {{-1, 0}, {0,1}, {1, 0}, {0, -1}};
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] matrix = new int[m][n];

        for(int i =0; i< m; i++){
            for(int j =0; j< n; j++){
                matrix[i][j] = grid[i][j];
            }
        }

        int islands = NumberOfIslands(matrix, m, n);
        if(islands == 0 || islands > 1){
            return 0;
        }

        for(int i =0; i< m; i++){
            for(int j =0; j< n; j++){
                if(grid[i][j] == 1){
                    for(int k =0; k< m; k++){
                        for(int l =0; l< n; l++){
                            matrix[k][l] = grid[k][l];
                        }
                    }
                    matrix[i][j] = 0;
                    islands = NumberOfIslands(matrix, m, n);
                    if(islands == 0 || islands > 1){
                        return 1;
                    }
                }
            }
        }

        return 2;
    }

    public int NumberOfIslands(int[][] matrix, int m, int n){
        int region =0;
        for(int i =0; i< m; i++){
            for(int j =0; j< n; j++){
                if(matrix[i][j] == 1){
                    dfs(matrix, i, j, m, n);
                    region++;
                }
            }
        }
        return region;
    }

    public void dfs(int[][] matrix, int i, int j, int m, int n){
        if(i < 0 || i >= m || j <0 || j>= n || matrix[i][j] == 0){
            return;
        }

        matrix[i][j] = 0;

        for(int k = 0; k < 4; k++){
            int new_i = i + dir[k][0];
            int new_j = j + dir[k][1];
            dfs(matrix, new_i, new_j, m, n);
        }
    }
}