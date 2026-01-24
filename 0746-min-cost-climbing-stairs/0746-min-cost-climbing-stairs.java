class Solution {
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

    // TODO - tabulation 
}