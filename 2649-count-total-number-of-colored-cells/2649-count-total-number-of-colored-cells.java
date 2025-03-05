class Solution {
    public long coloredCells(int n) {
        long cells = 1;
        for(int i = 2; i<= n; i++){
            cells += 4 * (i-1);
        }
        return cells;
    }
}