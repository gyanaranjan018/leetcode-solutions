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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> currrow = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();
                if(leftToRight){
                    currrow.add(node.val);
                }
                else{
                    currrow.add(0, node.val);
                }
                
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            leftToRight = !leftToRight;
            res.add(currrow);
        }
        return res;
    }
}