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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root); 
        return sum;
    }
    
    public void dfs(TreeNode cur){
        if(cur == null) return;
        TreeNode left = cur.left;
        TreeNode right = cur.right;
        dfs(left);
        dfs(right);
        if(cur.val % 2 == 0){
            if(left != null){
                TreeNode leftGranson = left.left;
                TreeNode rightGranson = left.right;
                if(leftGranson != null){
                    sum += leftGranson.val;
                }
                if(rightGranson != null){
                    sum += rightGranson.val;
                }
            }
            if(right != null){
                TreeNode leftGranson = right.left;
                TreeNode rightGranson = right.right;
                if(leftGranson != null){
                    sum += leftGranson.val;
                }
                if(rightGranson != null){
                    sum += rightGranson.val;
                }
            }
        }
    }
}