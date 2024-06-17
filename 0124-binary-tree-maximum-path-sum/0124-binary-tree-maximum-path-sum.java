/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxsum(root, max);
        return max[0];
    }
    public int maxsum(TreeNode node, int[] max){
        if(node == null){
            return 0;
        }
        int leftSum = Math.max(0, maxsum(node.left, max));
        int rightSum = Math.max(0, maxsum(node.right, max));
        max[0] = Math.max(max[0], node.val + leftSum + rightSum);
        return node.val + Math.max(leftSum, rightSum);
    }
}