class Solution {    
    public int solve(int n, int[] dp){
        if(n >= 0 && dp[n] != -1) return dp[n];
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        int one_step = solve(n-1, dp);
        int two_step = solve(n-2, dp);
        return dp[n] = one_step + two_step;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
}