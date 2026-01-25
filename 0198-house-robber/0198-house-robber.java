class Solution {
    /*
    // Memoization approch
    int[] dp = new int[100];

    public int solve(int i, int[] nums){
        if (i >= nums.length){
            return 0;
        }
        if (dp[i] != -1){
            return dp[i];
        }
        int take = nums[i] + solve(i+2, nums);
        int skip = solve(i+1, nums);
        return dp[i] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        Arrays.fill(dp, -1);
        int n = nums.length;
        if ( n == 1){
            return nums[0];
        }
        return solve(0, nums);
    }

    */


    // Tabulation approch
    public int rob(int[] nums) {
        int[] dp = new int[100];
        int n = nums.length;
        if ( n == 1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
}