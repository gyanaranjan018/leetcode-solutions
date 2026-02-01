class Solution {
    public int minimumCost(int[] nums) {
        int first = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;
        for (int i =1; i< nums.length; i++){
            if (nums[i] < first){
                sec = first;
                first = nums[i];
            }
            else if(nums[i] < sec){
                sec = nums[i];
            }
        }
        return nums[0] + first + sec;
    }
}