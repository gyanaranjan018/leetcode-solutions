class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0, oddCount = 0;
        int n = nums.length;
        int[] odd = new int[n+1];
        odd[0] = 1;
        for(int i = 0; i< n; i++){
            oddCount += (nums[i] % 2);            
            if(oddCount-k >= 0){
                result += odd[oddCount-k];
            }
            odd[oddCount]++;
        }
        return result;
    }
}