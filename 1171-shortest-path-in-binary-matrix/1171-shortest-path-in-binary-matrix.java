class Solution {
    class Tuple{
        int first, second, third;
        Tuple(int _first, int _second, int _third){
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1) return -1;
        if(n ==1) return 1;
        
        Queue<Tuple> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        for(int i =0; i< n; i++){
            for(int j =0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 1;
        q.add(new Tuple(1, 0, 0));
        //n*m
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int dis = it.first;
            int r = it.second;
            int c = it.third;
            //8
            for(int i = -1; i<= 1; i++){
                for(int j =-1; j<= 1; j++){
                    int newr = r + i;
                    int newc = c + j;

                    if(newr >=0 && newr<n && newc >= 0 && newc <n && grid[newr][newc] == 0 && dis+1 < dist[newr][newc]){
                        dist[newr][newc] = 1 + dis;
                        if(newr == n-1 && newc == n-1) return dis+1;
                        q.add(new Tuple(1+dis, newr, newc));
                    }
                }
            }
        }
        return - 1;
    }
}