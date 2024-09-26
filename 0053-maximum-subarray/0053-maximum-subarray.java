class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];

        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0) sum = 0;
        }
        
        return max;

        /**
        int maxsum = nums[0];
        int currsum = nums[0];
        for(int i = 1; i < nums.length; i++){
            currsum = Math.max(nums[i], currsum + nums[i]);
            maxsum = Math.max(maxsum, currsum);
        }
        return maxsum;
        **/
    }
}