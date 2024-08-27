class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prod = 1;
        int count = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0){
                prod *= nums[i];
            }
            else{
                count++;
            }        
        }

        if(count>1){
            return res;
        }

        for(int i =0; i< nums.length; i++){
            if(nums[i] == 0){
                res[i] = prod;
            }
            else if(count > 0){
                res[i] = 0;
            }
            else{
                res[i] = prod/nums[i];
            }
        }
        return res;
    }
}