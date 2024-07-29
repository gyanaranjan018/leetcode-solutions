class Solution {
    class Tuple{
    int distance, row, col;
    Tuple(int _distance, int _row, int _col){
        this.distance = _distance;
        this.row = _row;
        this.col = _col;
    }
}
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};
        //E logV
        //n * m * 4 * log(n * m)
        while(pq.size() != 0){
            int diff = pq.peek().distance;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();

            if(row == n-1 && col == m-1){
                return diff;
            }
            //4
            for(int i = 0; i<4; i++){
                int nrow = row + delr[i];
                int ncol = col + delc[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m)
                {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Tuple(newEffort, nrow, ncol));
                    } 
                }
            }
        }
        return 0;
    }
}