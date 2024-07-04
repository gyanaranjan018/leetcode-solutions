class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i< numCourses; i++){
            adj.add(new ArrayList());
        }

        for(int i =0; i< prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();       
        for(int i = 0; i< numCourses; i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        } 
        for(int i = 0; i< numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        return (cnt == numCourses);
    }
}