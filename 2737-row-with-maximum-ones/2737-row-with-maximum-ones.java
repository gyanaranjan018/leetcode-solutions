class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i< m; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                count += mat[i][j];
            }
            if(count > res[1]){
                res[0] = i;
                res[1] = count;
            }
        }
        return res;
    }
}