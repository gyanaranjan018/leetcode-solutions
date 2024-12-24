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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int l = 0;
        while(!q.isEmpty()){
            int n = q.size();
            List<TreeNode> list = new ArrayList<>();
            while(n--> 0){
                TreeNode curr = q.poll();
                list.add(curr);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(l % 2 != 0){
                int i = 0;
                int j = list.size() -1;
                while(i < j){
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(j).val;
                    list.get(j).val = temp;
                    i++;
                    j--;
                }   
            }
            l++;
        }
        return root;
    }
}