class Solution {
    /*
    // Top down approch
    public int solve(int[] nums, int i, int[] dp, int n){
        if(i > n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int steal = nums[i] + solve(nums, i+2, dp, n);
        int skip = solve(nums, i+1, dp, n);
        return dp[i] = Math.max(steal, skip);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);

        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        //case 1 - Take first house 0th index
        int take_0th_index_house = solve(nums, 0, dp, n-2);

        Arrays.fill(dp, -1);
        //Case 2 - skip first house 
        int take_1st_index_house = solve(nums, 1, dp, n-1);

        return Math.max(take_0th_index_house, take_1st_index_house);
    }
    */

    //Buttom up approch
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n + 1];
        //dp[i] = max stolen money till i house
        //case 1 take first house
        for(int i = 1; i<= n-1; i++){
            int steal = nums[i-1] + ( i-2 >= 0 ? dp[i - 2] : 0);
            int skip = dp[i-1];
            dp[i] = Math.max(steal, skip);
        }
        int case1 = dp[n-1];
        //case 2 skip first house
        Arrays.fill(dp, 0);
        for(int i = 2; i<= n; i++){
            int steal = nums[i-1] + dp[i - 2];
            int skip = dp[i-1];
            dp[i] = Math.max(steal, skip);
        }
        int case2 = dp[n];
        return Math.max(case1, case2);
    }
}