class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n];

        //step 1 : Build the diff array
        for(int i = 0; i < shifts.length; i++){
            int start = shifts[i][0];
            int end = shifts[i][1];
            int x = shifts[i][2];

            if(x == 1){ //Forward shift
                diff[start] += 1;
                if(end+1 < n) diff[end + 1] -= 1;
            }
            else{ //Backward shift
                diff[start] -= 1;
                if(end+1 < n) diff[end + 1] += 1;
            }
        }

        //step 2 : Find cumulative sum to find teh resultamt change/shift in the index
        for(int i = 1; i < n; i++){
            diff[i] += diff[i-1];
        }

        //Now apply the shift after change
        StringBuilder result = new StringBuilder(s);
        for(int i = 0; i < n; i++){
            int shift = diff[i] % 26; //wrap around
            
            if(shift < 0){
                shift += 26; //Handle negative shifts
            }

            char newChar = (char) (((result.charAt(i) - 'a' + shift) % 26) + 'a');
            result.setCharAt(i, newChar);
        }

        return result.toString();
    }
}