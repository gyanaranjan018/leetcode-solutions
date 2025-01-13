class Solution {
    public long solve(int idx, boolean flag, int[] nums, int n, long[][] dp){
        if(idx >= n){
            return 0;
        }
        if(dp[idx][flag ? 1 : 0] != -1){
            return dp[idx][flag ? 1 : 0];
        }
        long skip = solve(idx + 1, flag, nums, n, dp);
        long val = nums[idx];
        if(flag == false){
            val = -val;
        }
        long take = solve(idx+1, !flag, nums, n, dp) + val;
        return dp[idx][flag ? 1 : 0] = Math.max(skip, take);
    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, true, nums, n, dp);
    }
}