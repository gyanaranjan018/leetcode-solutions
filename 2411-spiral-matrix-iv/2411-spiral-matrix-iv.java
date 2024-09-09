/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int i =0; i< m; i++){
            for(int j =0; j<n; j++){
                res[i][j] = -1;
            }
        }
        int top = 0, down = m-1, left = 0, right = n-1;
        int id = 0;
        while(top <= down && left <= right){
            if(id == 0){ //left to right
                for(int i = left; i<= right && head != null; i++){
                    res[top][i] = head.val;
                    head = head.next;
                }
                top++;
            }
            if(id == 1){ //top to down
                for(int i = top; i<= down && head != null; i++){
                    res[i][right] = head.val;
                    head = head.next;
                }
                right--;
            }
            if(id == 2){ //right to left
                for(int i = right; i >= left && head != null; i--){
                    res[down][i] = head.val;
                    head = head.next;
                }
                down--;
            }
            if(id == 3){ //down to top
                for(int i = down; i >= top && head != null; i--){
                    res[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
            id = (id+1) % 4;
        }
        return res;
    }
}