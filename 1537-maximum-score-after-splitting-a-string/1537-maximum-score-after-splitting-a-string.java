class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] ones = new int[n];
        int[] zeros = new int[n];
        int max = -1;

        ones[n-1] = s.charAt(n-1) == '1' ? 1 : 0;
        zeros[0] = s.charAt(0) == '0' ? 1 : 0;

        for( int i = 1; i< n-1; i++){
            zeros[i] = zeros[i-1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        for( int i = n-2; i>= 0; i--){
            ones[i] = ones[i+1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        for(int i = 0; i< n-1; i++){
            if(zeros[i] + ones[i+1] > max){
                max = zeros[i] + ones[i+1];
            }
        }

        return max;
    }
}