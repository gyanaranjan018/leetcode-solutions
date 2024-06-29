class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> adj = new HashMap<>(); //S.C : O(V + E)

        for(int i = 0 ; i < n ; i++ ){
            adj.put(i,new ArrayList<>());
        }

        for(int[] i : edges){ //O(E)
            int u = i[0];
            int v = i[1];
            adj.get(v).add(u);
        }

        for(int u = 0; u< n; u++){ //O(V)
            boolean[] visited = new boolean[n];
            List<Integer> ancestor = new ArrayList<>();
            
            dfs(u, ancestor, adj, visited); //O(V+E)

            Collections.sort(ancestor);
            res.add(ancestor);
        }

        return res;
    }

    private void dfs(int node, List<Integer> ancestor, Map<Integer, List<Integer>> adj,  boolean[] visited){
        for(int ngbr : adj.get(node)){
            if(!visited[ngbr]){
                visited[ngbr] = true;
                ancestor.add(ngbr);
                dfs(ngbr, ancestor, adj, visited);
            }            
        }
        return;
    }
}