class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int output[] = new int[n];
        for(int i =0; i< n; i++){
            output[i] = Integer.MIN_VALUE;
        }
        int c= 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < i+n; j++){
                if(nums[i] < nums[j % n]){
                    output[c++] = nums[j%n];
                    break;
                }
            }
            if(output[i] == Integer.MIN_VALUE)
                output[c++] = -1;
        }
        return output;
    }
}