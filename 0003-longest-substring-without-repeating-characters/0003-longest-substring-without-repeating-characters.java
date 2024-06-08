class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0, j =0, ans = 0;
        int[] freq = new int[256];
        while(j < s.length()){
            freq[s.charAt(j)]++;
            if(freq[s.charAt(j)]==1){
                ans = Math.max(ans,j-i+1);
                j++;
            }
            else{
                while(freq[s.charAt(j)]>1){
                    freq[s.charAt(i)]--;
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}