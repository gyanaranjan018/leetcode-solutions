class Solution {

    public boolean checkPredecessor(String prev, String curr){
        if(curr.length() - prev.length() != 1){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < prev.length() && j < curr.length()){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            j++;
        }
        return i == prev.length();
    }

    /*
    //Recursion + Memoization
    public int solve(String[] words, int idx, int prev, int[][]dp){
        if(idx == words.length){
            return 0;
        }
        if(prev != -1 && dp[idx][prev] != -1){
            return dp[idx][prev];
        }

        int take = 0;
        if(prev == -1 || (checkPredecessor(words[prev], words[idx]))){
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
    */


    //Buttom Up Approch
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        int[] dp = new int[1001];
        Arrays.fill(dp, 1);
        int longest = 1;
        for(int i = 0; i< words.length; i++){
            for(int j = 0; j < i; j++){
                if(checkPredecessor(words[j], words[i])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    longest = Math.max(longest, dp[i]);
                }
            }
        }
        return longest;
    }
    

}