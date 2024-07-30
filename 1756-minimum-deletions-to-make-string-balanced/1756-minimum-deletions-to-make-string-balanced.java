class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int bCount = 0;
        int aCount = 0;
        int res = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--){
	        if(s.charAt(i) == 'a'){
		        aCount++;
	        }
        }
        for(int i = 0; i < n; i++){
	        if(s.charAt(i) == 'a') aCount--;
	            res = Math.min(bCount + aCount, res);
	        if(s.charAt(i) == 'b') bCount++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}