class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] map = new int[(n*n)+1];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                map[grid[i][j]]++;
            }
        }
        int[] res = new int[2];
        for(int i = 1; i<map.length; i++){
            if(map[i] > 1){
                res[0] = i;
            }
            else if(map[i] == 0){
                res[1] = i;
            }
        }
        return res;
    }
}