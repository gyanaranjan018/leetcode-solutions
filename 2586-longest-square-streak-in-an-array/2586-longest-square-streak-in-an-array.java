class Solution {
    public int longestSquareStreak(int[] nums) {
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
    }
}