class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] leftClosestR = new int[n];
        int[] rightClosestL = new int[n];
        char[] dominoArr = dominoes.toCharArray();


        // Move from left to right to find leftClosestR
        for(int i = 0; i < n; i++){
            if(dominoArr[i] == 'R'){
                leftClosestR[i] = i;
            }
            else if(dominoArr[i] == '.'){
                leftClosestR[i] = i > 0 ? leftClosestR[i-1] : -1;
            }
            else{
                leftClosestR[i] = -1;
            }
        }


        // Move from right to left to find rightClosestL
        for(int i = n-1; i >= 0; i--){
            if(dominoArr[i] == 'L'){
                rightClosestL[i] = i;
            }
            else if(dominoArr[i] == '.'){
                rightClosestL[i] = i < n-1 ? rightClosestL[i+1] : -1;
            }
            else{
                rightClosestL[i] = -1;
            }
        }


        for(int i = 0; i< n; i++){
            int distLeftR = Math.abs(i - leftClosestR[i]);
            int distRightL = Math.abs(i - rightClosestL[i]);

            if(leftClosestR[i] == rightClosestL[i]){ //if both -1
                dominoArr[i] = '.';
            }
            else if(leftClosestR[i] == -1){
                dominoArr[i] = 'L';
            }
            else if(rightClosestL[i] == -1){
                dominoArr[i] = 'R';
            }
            else if(distLeftR == distRightL){
                dominoArr[i] = '.';
            }
            else{
                dominoArr[i] = distLeftR < distRightL ? 'R' : 'L';
            }
        }
        
        return new String(dominoArr);
    }
}