class Solution {
    public int longestSquareStreak(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);

        int count = -1;

        for(int i : nums){
            int root = (int)Math.sqrt(i);
            if(root*root == i && map.containsKey(root)){
                map.put(i, map.get(root)+1);
                count = Math.max(count, map.get(i));
            }
            else{
                map.put(i, 1);
            }
        }

        return count;

        /* BRUTE - FORCE APPROCH
        HashSet<Double> set = new HashSet<>();
        for(int i : nums){
            set.add((double)i);
        }
        int count = 0;
        for(int curr : nums){
            int ccount = 1;
            double d = curr;
            while(true){
                 d *= d;
                if(set.contains(d)){
                    ccount++;
                }
                else{
                    break;
                }
            }
            count = Math.max(count, ccount);
        }
        return count > 1 ? count : -1;

        */
    }
}