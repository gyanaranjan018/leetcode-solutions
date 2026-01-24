class Solution {

    // Memoization Approch
    // Initilize the dp array 
    int[] dp = new int[38];

    public int solve(int n){
        if (dp[n] != -1){
            return dp[n];
        }

        if (n == 0){
            return 0;
        }
        
        if (n == 1){
            return 1;
        }

        if (n == 2){
            return 1;
        }

        return dp[n] = solve(n-1) + solve(n-2) + solve(n-3);
    }

    public int tribonacci(int n) {
        Arrays.fill(dp, -1);
        return solve(n);
    }
}