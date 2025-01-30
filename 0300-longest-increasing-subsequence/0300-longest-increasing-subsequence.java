class Solution {
    /*
    //Recursion + Memoization Solution 
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(nums, 0, -1, dp);
    }

    public int solve(int[] nums, int idx, int prev, int[][] dp){
        if(idx >= nums.length){
            return 0;
        }

        if(prev >= 0 && dp[idx][prev] != -1){
            return dp[idx][prev];
        }

        int take = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            take = 1 + solve(nums, idx+1, idx, dp);
        }

        int skip = solve(nums, idx+1, prev, dp);

        if(prev != -1){
            dp[idx][prev] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
    */

    /*
    //Buttom - Up approch
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLIS = 1;
        Arrays.fill(dp, 1);

        for(int i =0; i<n; i++){
            for(int j =0; j< i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLIS = Math.max(maxLIS, dp[i]);
                }
            }
        }

        return maxLIS;
    }
    */


    //(Using concept of Patience Sorting (O(nlogn))
    //T.C : O(nlogn)
    //S.C : O(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list= new ArrayList<>();
        for(int i = 0; i < n; i++){

            /*
                Why lower bound?
                We want an increasing subsequence, and hence
                we want to eliminate the duplicates as well.
                lower_bound returns the index of "next greater or equal to."
            */

            int lb = lowerBound(list, nums[i]);
            
            if (lb == list.size())
                list.add(nums[i]); // greatest: so insert it
            else
                list.set(lb, nums[i]); // replace
        }
        return list.size();
    }

    public int lowerBound(List<Integer> list, int target){
        int left = 0, right = list.size();
        int res = list.size();
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid;
            }
        }
        return res;
    }
}