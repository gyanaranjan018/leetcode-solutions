class Solution {
    public int minSwaps(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int tOnes = 0;
        for(int k = 0; k < n; k++){
            tOnes += nums[k];
        }
        if(tOnes == 0 || tOnes == n) return 0;
        int cOnes = 0;
        int swaps = Integer.MAX_VALUE;
        while(i < n){
            cOnes += nums[j%n];
            if(j-i+1 < tOnes) j++;
            else if(j-i+1 == tOnes){
                swaps = Math.min(swaps, tOnes - cOnes);
                cOnes -= nums[i];
                i++;
                j++;
            }
        }
        return swaps;
    }
}