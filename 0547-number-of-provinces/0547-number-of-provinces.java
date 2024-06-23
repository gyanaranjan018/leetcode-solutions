class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean visited[] = new boolean[v];
        int count = 0;
        for(int i = 0; i < v; i++){
            if(!visited[i]){
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }
    public void dfs(int v, int[][] isConnected, boolean[] visited){
        for(int i = 0; i < isConnected[v].length; i++){
            if(isConnected[v][i] == 1 && visited[i] == false){
                visited[i] = true;
                dfs(i, isConnected, visited);
            }
        }
    }

}