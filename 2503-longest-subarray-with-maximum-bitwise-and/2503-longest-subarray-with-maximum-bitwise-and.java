class Solution {
    public int longestSubarray(int[] nums) {
        int maxValue = 0;
        int maxLength = 0;
        int result = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxLength = 1;
                result = 0;
            }
            else if(nums[i] == maxValue){
                maxLength += 1;
            }
            else{
                maxLength = 0;
            }
            result = Math.max(result, maxLength);
        }

        return result;
    }
}