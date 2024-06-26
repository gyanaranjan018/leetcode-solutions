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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return solve(0, nodes.size()-1, nodes);
    }

    public TreeNode solve(int s, int e, List<Integer> nodes){
        if(s > e){
            return null;
        }
        int m = (s+e)/2;
        TreeNode root = new TreeNode(nodes.get(m));
        root.left = solve(s, m-1, nodes);
        root.right = solve(m+1, e, nodes);
        return root;
    }

    public void inorder(TreeNode root,List<Integer> nodes){
        if(root == null){
            return;
        }
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

}