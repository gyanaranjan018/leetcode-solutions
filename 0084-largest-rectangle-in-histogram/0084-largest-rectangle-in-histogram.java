class Solution {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer> st = new Stack<>();
         int maxArea = 0;
         int n = heights.length;
         for(int i = 0; i<= n; i++){
            while(!st.isEmpty() && (i == n || heights[i] <= heights[st.peek()])){
                int right = i;
                int height = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                int width = right - left -1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
         }
         return maxArea;
    }
}