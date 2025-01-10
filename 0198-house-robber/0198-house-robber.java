class Solution {
    /*
    // Top down approch(Recursion and memoization)
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }

    public int solve(int[] nums, int i, int[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int steal = nums[i] + solve(nums, i+2, dp);
        int skip = solve(nums, i+1, dp);
        return dp[i] = Math.max(steal, skip);
    }
    */

    //Buttom up approch
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n + 1];
        //dp[i] = max stolen money till i house
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i<= n; i++){
            int steal = nums[i-1] + dp[i - 2];
            int skip = dp[i-1];
            dp[i] = Math.max(steal, skip);
        }
        return dp[n];
    }
}