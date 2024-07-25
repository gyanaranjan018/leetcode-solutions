class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();

        for(int i = 0; i< v; i++){
            adjRev.add(new ArrayList<>());
        }

        int indegree[] = new int[v];

        for(int i = 0; i < v; i++){
            //i -> it
            //it -> i
            for(int it : graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < v; i++){
            if(indegree[i] ==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);
            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}