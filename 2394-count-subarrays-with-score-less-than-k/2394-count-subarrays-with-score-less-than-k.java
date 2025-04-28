class Solution {
    public long countSubarrays(int[] nums, long k) {
        //using Sliding window T.C - O(2n)
        long res = 0, sum = 0, score = 0;
        int n = nums.length;
        int i =0, j=0;
        while(j < n){
            sum += nums[j];

            while( i <= j && sum * (j-i+1) >= k){ //shrink the window
                sum -= nums[i];
                i++;
            }
            res += (j-i+1);
            j++;
        }
        return res;
    }
}