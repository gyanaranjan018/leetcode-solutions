class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i< numCourses; i++){
            adj.add(new ArrayList());
        }

        for(int i =0; i< prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
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

        int[] ans = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        if(i == numCourses)
            return ans;

        int[] arr = {};
        return arr;
        
    }
}