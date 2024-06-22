class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0, oddCount = 0, prevCount = 0;
        int n = nums.length;
        int i =0, j=0;
        while(j < n){
            if(nums[j] % 2 != 0){ //ODD
                oddCount++;
                prevCount = 0;
            }
            while(oddCount == k){
                prevCount++;
                if(nums[i] % 2  == 1){//ODD
                    oddCount--;
                } 
                i++;
            }
            result += prevCount;
            j++;
        }
        return result;
    }
}