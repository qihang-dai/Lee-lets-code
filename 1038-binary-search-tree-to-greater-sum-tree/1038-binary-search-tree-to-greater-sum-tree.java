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
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, new TreeNode(0));
        return root;
    }

    public void dfs(TreeNode root, TreeNode sum){
        if(root == null) return;
        dfs(root.right, sum);
        sum.val += root.val;
        root.val = sum.val;
        dfs(root.left, sum);
        
    }
}