class Solution {
    public int minSwaps(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int tOnes = 0;
        for(int k = 0; k < n; k++){
            if(nums[k] == 1) tOnes++;
        }
        if(tOnes == 0 || tOnes == n) return 0;
        int cOnes = 0;
        int swaps = Integer.MAX_VALUE;
        while(i < n){
            if(nums[j % n] == 1) cOnes++;
            if(j-i+1 < tOnes) j++;
            else if(j-i+1 == tOnes){
                swaps = Math.min(swaps, tOnes - cOnes);
                if(nums[i] == 1) cOnes--;
                i++;
                j++;
            }
        }
        return swaps;
    }
}