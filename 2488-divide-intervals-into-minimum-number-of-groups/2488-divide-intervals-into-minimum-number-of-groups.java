class Solution {
    public int minGroups(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        // Priority Queue (min-heap) to store the end points of the groups
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];

            // If the top of the queue (smallest end time) is smaller than the current start time
            // we can merge the interval into an existing group, so we pop the earliest end time
            if(!pq.isEmpty() && pq.peek() < start){
                pq.poll();
            }

            // Add the current interval's end time to the queue (new or updated group)
            pq.offer(end);
        }

        return pq.size();
        



        /*  Need to correct this code block
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<Integer> groups = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            boolean added = false;
            for(int j = 0; j < groups.size(); j++){
                if(groups.get(j) < intervals[i][0]){
                    groups.add(j, intervals[i][1]);
                    added = true;
                    break;
                }
            }
            if(!added){
                groups.add(intervals[i][1]);
            }
        } 

        return groups.size();
        */
    }
}