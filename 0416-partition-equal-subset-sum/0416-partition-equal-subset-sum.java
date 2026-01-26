class Solution {
    public boolean canPartition(int[] nums) {
        int total_sum = 0;
        for (int i =0; i < nums.length; i++){
            total_sum += nums[i];
        }

        if (total_sum % 2 != 0){
            return false;
        }

        int target = total_sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int num : nums){
            for (int s = target - num; s >= 0; s--){
                if (dp[s]){
                    dp[s+num] = true;
                }
            }
        }
        return dp[target];
    }
}