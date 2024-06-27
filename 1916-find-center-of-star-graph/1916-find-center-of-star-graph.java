class Solution {
    public int findCenter(int[][] edges) {
        int[] edge0 = edges[0];
        int[] edge1 = edges[1];

        if(edge0[0] == edge1[0] || edge0[0] == edge1[1]){
            return edge0[0];
        }
        return edge0[1];
    }
}