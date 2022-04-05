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
    StringBuilder res = new StringBuilder();
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        String left = root.left == null && root.right == null ? "" : "(" + tree2str(root.left) + ")";
        String right = root.right == null? "" : "(" + tree2str(root.right) + ")";
        
        return root.val  + left + right;
    }
}