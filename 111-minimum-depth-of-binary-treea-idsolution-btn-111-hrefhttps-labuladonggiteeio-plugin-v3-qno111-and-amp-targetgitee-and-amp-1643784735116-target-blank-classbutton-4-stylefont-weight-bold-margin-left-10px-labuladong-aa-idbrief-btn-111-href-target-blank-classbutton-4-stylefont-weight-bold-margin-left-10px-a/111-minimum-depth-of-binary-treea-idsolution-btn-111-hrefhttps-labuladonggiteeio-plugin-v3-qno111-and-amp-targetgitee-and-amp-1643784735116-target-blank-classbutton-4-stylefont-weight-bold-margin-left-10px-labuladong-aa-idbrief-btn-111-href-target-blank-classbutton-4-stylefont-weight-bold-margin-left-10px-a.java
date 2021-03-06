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
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        minDepth(root, 1);
        return min;
    }
    
    void minDepth(TreeNode root, int depth){
        if(root == null) return;
        minDepth(root.left, depth + 1);
        minDepth(root.right, depth + 1);
        if(root.left == null && root.right == null){
            min = Math.min(depth, min);
        }


    }
}