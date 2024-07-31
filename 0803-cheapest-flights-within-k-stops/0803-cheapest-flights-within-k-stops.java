class Solution {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Tuple {
        int stops;
        int node;
        int cost;

        Tuple(int _stops, int _node, int _cost) {
            this.stops = _stops;
            this.node = _node;
            this.cost = _cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int m = flights.length;
        for(int i = 0; i< n; i++){
        	adj.add(new ArrayList<>());
        }
        for(int i = 0; i< m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        int[] dist = new int[n];
        for(int i =0; i<n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        while(!q.isEmpty()){
            Tuple it = q.peek();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;
            q.remove();

            if(stops > k) continue;
            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edW= iter.second;
                if(cost + edW < dist[adjNode] &&stops <= k){
                    dist[adjNode] = cost +  edW;
                    q.add(new Tuple(stops+1, adjNode, cost + edW));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}