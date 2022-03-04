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
    int depth = 0;
    List<Integer> res = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root);
        return res;
    }
    
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        depth++;
        if(res.size() < depth){
            res.add(root.val);
        }
        dfs(root.right);
        dfs(root.left);
        depth--;//dfs回来了，深度一定要回归
    }
}