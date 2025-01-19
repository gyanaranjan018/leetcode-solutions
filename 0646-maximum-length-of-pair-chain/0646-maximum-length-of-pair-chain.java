class Solution {

    //Recursion + Memoization
    public int solve(int[][] pairs, int idx, int prev, int[][] dp){
        if(idx >= pairs.length){
            return 0;
        }

        if(prev >= 0 && dp[idx][prev] != -1){
            return dp[idx][prev];
        }

        int take = 0;
        if(prev == -1 || pairs[idx][0] > pairs[prev][1]){
            take = 1 + solve(pairs, idx+1, idx, dp);
        }

        int skip = solve(pairs, idx+1, prev, dp);

        if(prev != -1){
            dp[idx][prev] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        int[][] dp = new int[1001][1001];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(pairs, 0, -1, dp);
    }


    /*
    public int findLongestChain(int[][] pairs) {
        //Buttom up approch
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        for(int i = 0; i< n; i++){
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        return maxLength;
    }
    */
}