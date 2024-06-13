class Solution {
    public int largestRectangleArea(int[] heights) {
         int maxArea = 0;
         int n = heights.length;
         int[] stack = new int[n];
         int top = -1;
         for(int i = 0; i<= n; i++){
            while(top >= 0 && (i == n || heights[i] <= heights[stack[top]])){
                int right = i;
                int height = heights[stack[top]];
                top--;
                int left = top < 0 ? -1 : stack[top];
                int width = right - left -1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++top] = i;
         }
         return maxArea;
    }
}