class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l =0, r = letters.length-1;
        char ans = letters[0];
        while(l<=r){
            int mid = (l+r)/2;
            if(letters[mid] - 'a' > target - 'a'){
                ans = letters[mid];
                r = mid - 1;
            }
            else{
                l = mid +1;
            }
        }
        return ans;
    }
}