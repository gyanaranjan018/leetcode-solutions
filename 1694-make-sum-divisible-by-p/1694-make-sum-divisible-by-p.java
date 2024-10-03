class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        
        for(int i = 0; i< n; i++){
            sum= (sum + nums[i])%p;
        }

        int target = sum % p;

         // If sum is already divisible by p, no need to remove any subarray
        if(target == 0){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int curr = 0;
        int result = n;

        for(int i = 0; i< n; i++){
            curr = (curr + nums[i])%p;

            // Calculate the remainder needed to achieve the target
            int remain = (curr - target + p) % p;

             // If the required remainder exists in the map, update the result
            if(map.containsKey(remain)){
                result = Math.min(result, i-map.get(remain));
            }

            // Store the current remainder with its index
            map.put(curr, i);
        }

        return result == n ? -1 : result;
    }
}