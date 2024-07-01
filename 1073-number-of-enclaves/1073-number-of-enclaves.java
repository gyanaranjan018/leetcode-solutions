class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int row = 0; row < n; row++){
            if(!vis[row][0] && grid[row][0] == 1){
                q.add(new Pair(row, 0));
                vis[row][0] = true;
            }
            if(!vis[row][m-1] && grid[row][m-1] == 1){
                q.add(new Pair(row, m-1));
                vis[row][m-1] = true;
            }
        }

        for(int col = 0; col < m; col++){
            if(!vis[0][col] && grid[0][col] == 1){
                q.add(new Pair(0, col));
                vis[0][col] = true;
            }
            if(!vis[n-1][col] && grid[n-1][col] == 1){
                q.add(new Pair(n-1, col));
                vis[n-1][col] = true;
            }
        }

        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            for(int i =0; i< 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }   
        }

        int count = 0;

        for(int i =0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}