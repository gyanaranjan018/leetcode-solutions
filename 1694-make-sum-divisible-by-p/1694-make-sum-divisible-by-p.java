class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i< n; i++){
            sum= (sum + nums[i])%p;
        }
        int target = sum % p;

        if(target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curr = 0;
        int result = n;
        for(int i = 0; i< n; i++){
            curr = (curr + nums[i])%p;
            int remain = (curr - target + p) % p;
            if(map.containsKey(remain)){
                result = Math.min(result, i-map.get(remain));
            }
            map.put(curr, i);
        }
        return result == n ? -1 : result;
    }
}