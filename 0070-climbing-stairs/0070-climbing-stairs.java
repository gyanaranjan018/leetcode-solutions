class Solution {

    /* 
    //Memoization or Top Down Approch
    int[] dp = new int[46];

    public int solve(int n){
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        if(n == 0){
            return 1;
        }
        int one_step = solve(n-1);
        int two_step = solve(n-2);

        return dp[n] = one_step + two_step;
    }

    public int climbStairs(int n) {
        Arrays.fill(dp, -1);
        return solve(n);
    }
    */

    //Buttom Up Approch
    /*
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] dp = new int[46];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    */

    //without space

    public int climbStairs(int n) {
        if(n <= 2) return n;
        int a = 1;
        int b = 2;
        int c;
        for(int i = 3; i<= n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return b;
    }
     
}