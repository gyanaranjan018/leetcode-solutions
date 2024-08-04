class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        long resArr[] = new long[(n*(n+1))/2];
        int c = 0;
        long mod = 1000000007;
        for(int i = 0; i< n; i++){
            long sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                resArr[c++] = sum;
            } 
        }

        Arrays.sort(resArr);
        long res = 0;
        for(int i = left-1; i< right; i++){
            res += resArr[i];
        }
        return (int)(res % mod);
    }
}