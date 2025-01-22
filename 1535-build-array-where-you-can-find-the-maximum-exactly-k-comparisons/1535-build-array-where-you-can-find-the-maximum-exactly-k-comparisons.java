class Solution {
    //Recursion + Memoization
    int N, M, K;
    int MOD = 1000000007;
    int[][][] dp;
    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        dp = new int[51][51][101];

        for(int i =0; i< 51; i++){
            for(int j =0; j< 51; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, 0);
    }

    public int solve(int idx, int searchCost, int maxSoFar){
        if(idx == N){
            if(searchCost == K){
                return 1;
            }
            return 0;
        }

        if(dp[idx][searchCost][maxSoFar] != -1){
            return dp[idx][searchCost][maxSoFar];
        }

        int res = 0;
        for(int i = 1; i <= M; i++){
            if(i > maxSoFar){
                res = (res + solve(idx+1, searchCost+1, i)) % MOD;
            }
            else{
                res = (res + solve(idx+1, searchCost, maxSoFar)) % MOD;
            }
        }

        return dp[idx][searchCost][maxSoFar] = res % MOD;
    }
}