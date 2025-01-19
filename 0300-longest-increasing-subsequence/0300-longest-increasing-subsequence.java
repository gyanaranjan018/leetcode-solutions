class Solution {
    /*
    //Recursion + Memoization Solution 
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(nums, 0, -1, dp);
    }

    public int solve(int[] nums, int idx, int prev, int[][] dp){
        if(idx >= nums.length){
            return 0;
        }

        if(prev >= 0 && dp[idx][prev] != -1){
            return dp[idx][prev];
        }

        int take = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            take = 1 + solve(nums, idx+1, idx, dp);
        }

        int skip = solve(nums, idx+1, prev, dp);

        if(prev != -1){
            dp[idx][prev] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
    */

    //Buttom - Up approch
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);

        for(int i =0; i<n; i++){
            for(int j =0; j< i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}