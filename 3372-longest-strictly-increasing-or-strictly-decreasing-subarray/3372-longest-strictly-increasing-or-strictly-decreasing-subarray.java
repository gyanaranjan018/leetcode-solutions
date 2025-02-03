class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int res =1;
        int inc = 1, dec = 1;
        for(int i = 1; i < n; i++){
            //Increasing subarray
            if(nums[i] > nums[i-1]){
                inc++;
                res = Math.max(res, inc);
            }
            else{
                inc = 1;
            }

            //Decreasing subarray
            if(nums[i] < nums[i-1]){
                dec++;
                res = Math.max(res, dec);
            }
            else{
                dec = 1;
            }
        }
        return res;
    }
}