class Solution {
    public int findNumbers(int[] nums) {
        /*
        // Approch 1 Brute force
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int count = 0;
            while(num > 0){
                num = num/10;
                count++;
            }
            if(count % 2 == 0){
                result++;
            }
        }
        return result;
        */

        // Approch 2 converting number to string
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            String str = (String.valueOf(nums[i]));
            if(str.length() % 2 == 0){
                result++;
            }
        }
        return result;
    }
}