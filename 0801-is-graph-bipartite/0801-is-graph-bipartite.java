class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for(int i =0; i< graph.length; i++) color[i] = -1;

        for(int i = 0; i< graph.length; i++){
            if(color[i] == -1){
                if(checkDfs( i , graph, color, 0) == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    //DFS to color the graph nodes
    private boolean checkDfs(int start, int[][] graph, int[] color, int cc){
        color[start] = cc;

        for(int it : graph[start]){
            if(color[it] == -1){
                if(checkDfs(it, graph, color, 1 - cc) == false){
                    return false;
                }
            }
            else if(color[it] == color[start]){
                return false;
            }
        }

        return true;
    }
}