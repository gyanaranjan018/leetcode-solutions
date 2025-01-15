class Solution {
    /*
    //Recursion + Memoization
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
    */

    //Buttom Up Approch
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];

        for(int i = 1; i<= n; i++){
            //even
            dp[i][0] = Math.max(dp[i-1][1] - nums[i-1], dp[i-1][0]);
            //odd
            dp[i][1] = Math.max(dp[i-1][0] + nums[i-1], dp[i-1][1]);
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}