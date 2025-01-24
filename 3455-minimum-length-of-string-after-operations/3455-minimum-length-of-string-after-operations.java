class Solution {
    public int minimumLength(String s) {
        int n = s.length();

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c-'a']++; 
        }

        int res = 0;
        for(int i =0; i< 26; i++){
            if(freq[i] == 0){
                continue;
            }
            if(freq[i] % 2 == 0){
                res += 2;
            }
            else{
                res += 1;
            }
        }
        return res;
    }
}