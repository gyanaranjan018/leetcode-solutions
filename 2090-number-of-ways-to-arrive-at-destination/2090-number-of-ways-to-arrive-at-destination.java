class Solution {
    class Pair{
        long first, second;
        Pair(long first, long second){
	        this.first = first;
	        this.second = second;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        int m = roads.length;

        for(int i = 0; i< m; i++){
	        adj.get(roads[i][0]).add(new Pair(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][0]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));

        long[] dist = new long[n];
        long[] ways = new long[n];

        for(int i = 0; i< n; i++){  
	        dist[i] = Long.MAX_VALUE;
	        ways[i] = 0;
        }

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));
        int mod = (int)(1e9 + 7);
        while(pq.size() != 0){
	        long dis = pq.peek().first;
	        int node = (int)pq.peek().second;
	        pq.remove();

	        for(Pair it : adj.get(node)){
		        long edW = it.first;
                int adjNode = (int)it.second;
		        //this is the first time I ama coming with this short distance
		        if(dis + edW < dist[adjNode]){
			        dist[adjNode] = dis + edW;
			        pq.add(new Pair(dis + edW, adjNode));
			        ways[adjNode] = ways[node];
		        }
		        else if(dis + edW == dist[adjNode] ){
			        ways[adjNode] = (ways[adjNode] + ways[node])% mod;
		        }
	        }
        }
        return (int)(ways[n-1]%mod);
    }
}