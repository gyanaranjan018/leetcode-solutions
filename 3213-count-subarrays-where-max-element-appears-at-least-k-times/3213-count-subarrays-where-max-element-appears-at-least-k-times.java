class Solution {
    
    
    public long countSubarrays(int[] nums, int k) {
        int max = -1;
        int n = nums.length;
        // Find maximum element of nums
        for(int i = 0; i < n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        /*
        // Approch 1 - Sliding Window
        long res = 0;
        int i = 0, j = 0;
        int count = 0;
        while(j < n){
            if(nums[j] == max){
                count++;
            }
            while(i <= j && count >= k){
                res += (n-j);
                if(nums[i] == max){
                    count--;
                }
                i++;
            }
            j++;
        }
        return res;
        */
    
        // Approch 2 - Index Tracking
        long res = 0;
        int i = 0;
        int count = 0;
        List<Integer> indices = new ArrayList<>();
        while(i < n){
            if(nums[i] == max){
                count++;
                indices.add(i);
            }
            if(count >= k){
                int index = indices.get(indices.size() - k);
                res += (index + 1);
            }
            i++;
        }
        return res;
    }
}