class Solution {

    // Directions array for moving up, down, left, and right
    private int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        int region = 0;

        int[][] matrix = new int[rows*3][cols*3];
        //creating 3*3 matrix for each symbol
        for(int i =0; i< rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i].charAt(j) == '/'){
                    matrix[i*3][j*3 + 2] = 1;
                    matrix[i*3 + 1][j*3 + 1] = 1;
                    matrix[i*3 + 2][j*3] = 1;
                }
                else if(grid[i].charAt(j) == '\\'){
                    matrix[i*3][j*3] = 1;
                    matrix[i*3 + 1][j*3 + 1] = 1;
                    matrix[i*3 + 2][j*3 + 2] = 1;
                }
            }
        }

        //Apply conect of 'Number of Island'

        for(int i =0; i< matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    //DFS
                    dfs(matrix, i, j);
                    region++;
                }
            }
        }        
        return region;
    }

    public void dfs(int[][] matrix, int i, int j){
        if(i < 0 || i >= matrix.length || j< 0 || j >= matrix[0].length || matrix[i][j] == 1){
            return;
        }

        matrix[i][j] = 1;

        // Explore all four directions
        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            dfs(matrix, new_i, new_j);
        }
    }
}