class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int i = 0 ; i < n ; i++ ){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge : edges ){
            int from = edge[0];
            int to = edge[1];
            adj.get(to).add(from);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            List<Integer> temp = new ArrayList<>();
            int[] vis = new int[n];
            dfs(i , vis , temp , adj);
            Collections.sort(temp);
            ans.add(temp);
        }
        
        return ans;
    }
    
    public void dfs(int cur , int[] vis, List<Integer> temp, HashMap<Integer,List<Integer>> adj){
        vis[cur] = 1;
        for(Integer nbr : adj.get(cur)){
            if( vis[nbr] == 0 ){
                temp.add(nbr);
                dfs(nbr , vis, temp, adj);
                // temp.remove(nbr);
            }    
        }
        // vis[cur] = 0;
        return;
    }
    
}