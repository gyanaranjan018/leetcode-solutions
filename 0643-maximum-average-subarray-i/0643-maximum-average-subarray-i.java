class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, result = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while(j < nums.length){
            sum += nums[j];
            if(i <= j && j-i+1 > k){
                sum -= nums[i];
                i++;
            }
            if(j-i+1 == k){
                double avg = sum/k;
                if(avg > result){
                    result = avg;
                }
            }      
            j++;
        }
        return result;
    }
}