class Solution {
    public int maxWidthRamp(int[] nums) {

        // Optimal Approch
        int n = nums.length, maxDepth = 0;
        int[] maxToRight = new int[n];
        maxToRight[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            maxToRight[i] = Math.max(maxToRight[i+1], nums[i]);
        }

        int i = 0, j = 0;
        while(j < n){
            if(nums[i] <= maxToRight[j]){
                maxDepth = Math.max(maxDepth, j-i);
                j++; 
            }
            else{
                i++;
            }
        }

        return maxDepth;

        /*
        //Better Approch
        int n = nums.length, max_depth = 0;
        for(int i = 0; i < n; i++){
            for(int j = n-1; j > i; j--){
                if(nums[i] <= nums[j]){
                    max_depth = Math.max(max_depth, j-i);
                    break;
                }
            }
        }
        return max_depth;
        */



        /* Brute force - TLE, T.C  - O(n^2) 
        int n = nums.length, max_depth = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] <= nums[j]){
                    max_depth = Math.max(max_depth, j-i);
                }
            }
        }
        return max_depth;
        */
    }
}