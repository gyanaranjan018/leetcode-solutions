class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        int[] safeNodes = new int[v];
        List<Integer> res = new ArrayList<>();

        for(int i =0; i< v; i++){
            if(vis[i] == 0){
                check(i, graph, vis, pathVis, safeNodes);
            }
        }

        for(int i = 0; i < v; i++){
            if(safeNodes[i] == 1){
                res.add(i);
            }
        }
        return res;
    }

    private boolean check(int node, int[][] graph, int[] vis, int[] pathVis, int[] safeNodes){
        vis[node] = 1;
        pathVis[node] = 1;
        safeNodes[node] = 0;

        for(int it : graph[node]){
            //when node is not visited
            if(vis[it] == 0){
                if(check(it, graph, vis, pathVis, safeNodes) == true){
                    return true;
                }
            }
            //if the node has been previously visited but it has to be visited on the same path 
            else if(pathVis[it] == 1){ 
                return true;
            }
        }
        safeNodes[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}