class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int i = 0; i < rows - 2; i++){
            for(int j = 0; j < cols - 2; j++){
                if(isMagicGrid(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isMagicGrid(int[][] grid, int r, int c){
        //validate should have 1-9 integers and no duplicates
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 3; i++){
            for(int j =0; j< 3; j++){
                int num = grid[r+i][c+j];
                if(num < 1 || num > 9 || set.contains(num)){
                    return false;
                }
                else{
                    set.add(num);
                }
            }
        }

        //Calculate Sum
        int Sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];

        //Validate Rows Sum and Cols sum
        for(int i =0; i< 3; i++){
            if(grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != Sum){
                return false;
            }
            if(grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i] != Sum){
                return false;
            }
        }

        //Validate diagonals
        if(grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != Sum){
            return false;
        }

        //validate Anti-diagonal
        if(grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != Sum){
            return false;
        }

        return true;

    }
}