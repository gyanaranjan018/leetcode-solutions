class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int row = 0; row < n; row++){
            //first column
            if(!vis[row][0] && board[row][0] == 'O'){ 
                dfs(row, 0, vis, board, delRow, delCol);
            }
            //last column
            if(!vis[row][m-1] && board[row][m-1] == 'O'){
                dfs(row, m-1, vis, board, delRow, delCol);
            }
        }
        for(int col = 0; col < m; col++){
            //first row
            if(!vis[0][col] && board[0][col] == 'O'){
                dfs(0, col, vis, board, delRow, delCol);
            }
            //last row
            if(!vis[n-1][col] && board[n-1][col] == 'O'){
                dfs(n-1, col, vis, board, delRow, delCol);
            }
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    //dfs traversal
    public void dfs(int row, int col, boolean[][] vis, char[][] board, int[] delRow, int[] delCol){
        vis[row][col] = true;

        int n = board.length;
        int m = board[0].length;

        //check for top, right, buttom, left
        for(int i = 0; i< 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && !vis[nrow][ncol]){
                dfs(nrow, ncol, vis, board, delRow, delCol);
            }
        }
        return;
    }
}