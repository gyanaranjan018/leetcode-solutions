class Solution {

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
}