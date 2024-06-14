class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        for(int i = 0; i<m; i++){
            heights[i] = Character.getNumericValue(matrix[0][i]);
        }
        int currmax = largestRectangleArea(heights);
        max = Math.max(max, currmax);
        for(int i = 1; i< n; i++){
            for(int j =0; j<m; j++){
                if(matrix[i][j] == '0'){
                    heights[j]  = 0;
                }
                else{
                    heights[j] = heights[j] + Character.getNumericValue(matrix[i][j]);
                }
            }
            currmax = largestRectangleArea(heights);
            max = Math.max(max, currmax);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i <= n; i++) {
            while (top >= 0 && (i == n || heights[i] <= heights[stack[top]])) {
                int right = i;
                int height = heights[stack[top]];
                top--;
                int left = top < 0 ? -1 : stack[top];
                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++top] = i;
        }
        return maxArea;
    }
}