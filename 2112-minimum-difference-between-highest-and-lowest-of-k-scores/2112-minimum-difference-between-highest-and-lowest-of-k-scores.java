class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1) return 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i = 0, j = k-1;
        while(j < nums.length){
            min = Math.min(min, nums[j++] - nums[i++]);
        }
        return min;
    }
}