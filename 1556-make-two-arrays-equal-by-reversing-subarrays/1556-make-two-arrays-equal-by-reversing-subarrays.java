class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] map = new int[1001];
        for(int i : target){
            map[i]++;
        }
        for(int i : arr){
            if(map[i] == 0){
                return false;
            }
            map[i]--;
        }
        return true;
    }
}