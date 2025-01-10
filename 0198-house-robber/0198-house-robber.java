class Solution {
    static int steal = 0;
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }

    public int solve(int[] nums, int i, int[] dp){
        int steal = 0;
        int skip = 0;
        if(i < nums.length){
            if(dp[i] != -1){
                return dp[i];
            }
            steal += nums[i] + solve(nums, i+2, dp);
            skip = solve(nums, i+1, dp);
            return dp[i] = Math.max(steal, skip);
        }
        return 0;
    }
}