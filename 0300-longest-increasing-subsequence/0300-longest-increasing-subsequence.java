class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(nums, 0, -1, dp);
    }

    public int solve(int[] nums, int idx, int prev, int[][] dp){
        int take = 0;
        int skip = 0;
        if(idx >= nums.length){
            return 0;
        }

        if(prev >= 0 && dp[idx][prev] != -1){
            return dp[idx][prev];
        }
        if(prev == -1){
            take = 1 + solve(nums, idx+1, idx, dp);
        }
        else if(nums[idx] > nums[prev]){
            take = 1 + solve(nums, idx+1, idx, dp);
        }
        skip = solve(nums, idx+1, prev, dp);
        if(prev == -1){
            return Math.max(take, skip);
        }
        return dp[idx][prev] = Math.max(take, skip);
    }
}