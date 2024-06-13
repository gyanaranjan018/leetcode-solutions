class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsr = nearestSmallestRight(heights);
        int[] nsl = nearestSmallestLeft(heights);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int left = nsl[i];
            int right = nsr[i];
            ans = Math.max(ans, heights[i] * ((right-left) - 1)); 
        }
        return ans;
    }
    public int[] nearestSmallestRight(int[] heights){
        int[] stack = new int[heights.length];
        int peek = -1;
        int[] res = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--){
            while(peek >= 0 && heights[i] <= heights[stack[peek]]){
                peek--;
            }
            if(peek < 0){
                res[i] = heights.length;
            }
            else{
                res[i] = stack[peek];
            }
            stack[++peek] = i;
        }
        return res;
    }

    public int[] nearestSmallestLeft(int[] heights){
        int[] stack = new int[heights.length];
        int peek = -1;
        int[] res = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            while(peek >= 0 && heights[i] <= heights[stack[peek]]){
                peek--;
            }
            if(peek < 0){
                res[i] = -1;
            }
            else{
                res[i] = stack[peek];
            }
            stack[++peek] = i;
        }
        return res;
    }
}