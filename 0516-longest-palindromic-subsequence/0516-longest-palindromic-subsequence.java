class Solution {
    // Recursion + Memo
    int[][] dp = new int[1001][1001];
    public int solve(String s, int i, int j){
        if (j < i){
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        if (i == j){
            return 1;
        }

        if (s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + solve(s, i+1, j-1);
        }
        else {
            return dp[i][j] = Math.max(solve(s, i, j-1), solve(s, i+1, j));
        }
    }

    public int longestPalindromeSubseq(String s) {
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        int n = s.length();
        return solve(s, 0, n-1);
    }
}