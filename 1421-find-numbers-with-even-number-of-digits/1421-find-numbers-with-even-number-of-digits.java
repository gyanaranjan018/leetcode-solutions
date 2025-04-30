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

        /*
        // Approch 2 converting number to string
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            String str = (String.valueOf(nums[i]));
            if(str.length() % 2 == 0){
                result++;
            }
        }
        return result;
        */

        /*
        // Approch 3 (Using floor(log num base 10) + 1 formula)

        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int digits = (int)Math.floor(Math.log10(nums[i])) + 1;
            if(digits % 2 == 0){
                result++;
            }
        }
        return result;
        */

        /*
        // Approch 4 (Using ceil)
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int digits = (int)Math.ceil(Math.log10(nums[i]+1));
            if(digits % 2 == 0){
                result++;
            }
        }
        return result;
        */


        //Approch 5 (Basic observation of the input)
        int result = 0;
        for(int num : nums){
            if((num > 9 && num < 100) || (num > 999 && num < 10000) || (num == 100000)){
                result++;
            }
        }
        return result;
    }
}