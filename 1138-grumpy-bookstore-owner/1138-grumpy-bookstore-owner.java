class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfied = 0;
        for(int i =0; i<n; i++){
            if(grumpy[i] == 0){
                satisfied += customers[i];
            }
        }
        int max = satisfied;
        int i = 0, j = 0;
        while(j < n){
            if(grumpy[j] == 1){
                max += customers[j];
            }
            if(j-i+1 < minutes){
                j++;
            }
            else if(j-i+1 == minutes){
                satisfied = Math.max(satisfied, max);
                if(grumpy[i] == 1){
                    max -= customers[i];
                }
                i++;
                j++;
            }
        }
        return satisfied;
    }
}