class Solution {
    public int findMaxLength(int[] nums) {
        int preSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0) preSum--;
            else preSum++;
            
            if(!map.containsKey(preSum)){
                map.put(preSum, i);
            }
            else{
                maxLength = Math.max(maxLength, i - map.get(preSum));
            }
        }
        return maxLength;
    }

    /* BRUTE FORCE SOLUTION 

        -- find all the subarrays and then check if it has equal count of 0 and 1 by making 0 as -1
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        for(int i =0; i < n; i++){
            for(int j = i; j<n; j++){
                if(helper(nums, i, j)){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
    public boolean helper(int[] nums, int start , int end){
        int sum = 0;
        for(int i = start; i <= end; i++){
            if(nums[i] == 0){
                sum += -1;
            }
            else{
                sum += nums[i];
            }
        }
        return sum == 0;
    }
    */
}