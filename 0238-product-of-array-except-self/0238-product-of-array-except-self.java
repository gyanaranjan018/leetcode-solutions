class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1; 
        //calculate prefixProduct and store it in res
        for(int i =1; i< nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        //calucate suffix sum 
        int suffixProduct = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            suffixProduct *= nums[i+1];
            res[i] = res[i] * suffixProduct;
        }
        return res;
    }
}