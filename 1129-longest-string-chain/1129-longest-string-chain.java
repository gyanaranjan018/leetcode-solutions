class Solution {

    public boolean isSubset(String word1, String word2){
        int totalskip = 0;
        int i = 0;
        int j = 0;
        while(i < word1.length() || j < word2.length()){
            if(i >= word1.length() || word1.charAt(i) != word2.charAt(j)){
                totalskip++;
                if(totalskip > 1){
                    return false;
                }
                j++;
            }
            else{
                i++;
                j++;
            }
        }
        return totalskip == 1;
    }
    public int solve(String[] words, int idx, int prev, int[][]dp){
        if(idx >= words.length){
            return 0;
        }
        if(prev != -1 && dp[idx][prev] != -1){
            return dp[idx][prev];
        }

        int take = 0;
        if(prev == -1 || (words[idx].length() - words[prev].length() == 1 && isSubset(words[prev], words[idx]))){
            take = solve(words, idx+1, idx, dp) + 1;
        }
        int skip = solve(words, idx+1, prev, dp);

        if(prev != -1){
            dp[idx][prev] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        int[][] dp = new int[1001][1001];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(words, 0, -1, dp);
    }

}