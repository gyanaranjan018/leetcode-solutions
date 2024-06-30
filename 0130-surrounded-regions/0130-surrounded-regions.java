class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int row = 0; row < n; row++){
            if(board[row][0] == 'O'){
                dfs(row, 0, vis, board);
            }
        }
        for(int row = 0; row < n; row++){
            if(board[row][m-1] == 'O'){
                dfs(row, m-1, vis, board);
            }
        }
        for(int col = 0; col < m; col++){
            if(board[0][col] == 'O'){
                dfs(0, col, vis, board);
            }
        }
        for(int col = 0; col < m; col++){
            if(board[n-1][col] == 'O'){
                dfs(n-1, col, vis, board);
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

    public void dfs(int row, int col, boolean[][] vis, char[][] board){
        vis[row][col] = true;

        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i< 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && !vis[nrow][ncol]){
                dfs(nrow, ncol, vis, board);
            }
        }
        return;
    }
}