class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int maxlen = 0;
        for(int i =0; i < s.length(); i++){
            int l1 = getLength(s, i, i);
            int l2 = getLength(s, i, i+1);
            int l = Math.max(l1, l2);
            if(maxlen < l){
                maxlen = l;
                start = i - (l-1)/2; 
            }
        }
        return s.substring(start, start + maxlen);
    }
    public int getLength(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}