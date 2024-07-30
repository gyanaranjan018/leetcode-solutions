class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] leftB = new int[n];
        int[] rightA = new int[n];
        int bCount = 0;
        for(int i = 0; i < n; i++){
	        leftB[i] = bCount;
	        if(s.charAt(i) == 'b'){
		        bCount++;
	        }
        }

        int aCount = 0;
        for(int i = n-1; i >= 0; i--){
	        rightA[i] = aCount;
	        if(s.charAt(i) == 'a'){
		        aCount++;
	        }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
	        res = Math.min(leftB[i]+rightA[i], res);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}