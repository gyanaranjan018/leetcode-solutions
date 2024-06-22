class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0, oddCount = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(oddCount, 1);
        for(int i = 0; i< n; i++){
            if(nums[i] % 2 == 1){
                oddCount++;
            }            
            if(map.containsKey(oddCount-k)){
                result += map.get(oddCount-k);
            }
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }
        return result;
    }
}