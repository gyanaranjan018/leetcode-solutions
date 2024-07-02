class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for(int i =0; i< graph.length; i++) color[i] = -1;

        for(int i = 0; i< graph.length; i++){
            if(color[i] == -1){
                if(check( i , graph, color) == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    //BFS to color the graph nodes
    private boolean check(int start, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : graph[node]){
                //if the node is not colord then color node with opposite color of adj node
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                //if node is colored then check with adj nodes color if it is same then it is not a bipartite graph.
                else if( color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}