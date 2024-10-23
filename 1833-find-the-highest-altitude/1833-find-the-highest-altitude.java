class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int curr_sum = 0;
        for(int i = 0; i< gain.length; i++){
            curr_sum += gain[i];
            res = Math.max(res, curr_sum);
        }
        return res;
    }
}