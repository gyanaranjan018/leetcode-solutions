class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = -1;
        int n = nums.length;
        // Find maximum element of nums
        for(int i = 0; i < n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        // Sliding window
        long res = 0;
        int i = 0, j = 0;
        int count = 0;
        while(j < n){
            if(nums[j] == max){
                count++;
            }
            while(i <= j && count >= k){
                res += (n-j);
                if(nums[i] == max){
                    count--;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}