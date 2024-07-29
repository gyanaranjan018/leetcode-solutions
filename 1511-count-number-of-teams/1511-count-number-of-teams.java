class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        int n = rating.length;
        for(int j = 1; j<n-1; j++){
            int countLargerLeft = 0;
            int countSmallerLeft = 0;
            for(int i = 0; i < j ;i++){
                if(rating[i] < rating[j]) countSmallerLeft++;
                else if(rating[i] > rating[j]) countLargerLeft++;
            }
            int countLargerRight = 0;
            int countSmallerRight = 0;
            for(int k = j+1; k < n ;k++){
                if(rating[k] > rating[j]) countLargerRight++;
                else if(rating[k] < rating[j]) countSmallerRight++;
            }
            count += countSmallerLeft * countLargerRight;
            count += countLargerLeft * countSmallerRight;
        }
        return count;
    }
}