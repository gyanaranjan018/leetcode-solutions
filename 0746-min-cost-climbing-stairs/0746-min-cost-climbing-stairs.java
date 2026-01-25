class Solution {
    /*
    // Memoization approch
    int[] dp = new int[1000];

    public int solve(int i, int[] cost){
        if (i == 0 || i == 1){
            return cost[i];
        }
        if (dp[i] != -1){
            return dp[i];
        }
        
        return dp[i] = cost[i] + Math.min(solve(i-1, cost), solve(i-2, cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(dp, -1);
        int n = cost.length;
        return Math.min(solve(n-1, cost), solve(n-2, cost));
    }

    */

    // Tabulation approch
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[1000];
        int n = cost.length;
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}