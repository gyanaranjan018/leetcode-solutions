class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int res[][] = new int[m][n];
        if(original.length != m*n){
            return new int[][]{};
        }
        for(int i = 0; i < original.length; i++){
            int row = i / n;
            int col = i % n;
            res[row][col] = original[i];
        }
        return res;
    }
}