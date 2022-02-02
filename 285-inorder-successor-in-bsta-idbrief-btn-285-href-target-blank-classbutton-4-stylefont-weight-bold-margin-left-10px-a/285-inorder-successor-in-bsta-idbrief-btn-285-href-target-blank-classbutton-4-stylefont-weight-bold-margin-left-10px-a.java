/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        TreeNode successor = null;
        if(root.val > p.val){
            successor = inorderSuccessor(root.left, p);
            if(successor == null){
                successor = root;
            }
        }
        if(root.val < p.val){
           return inorderSuccessor(root.right, p);
        }
        if(root.val == p.val){
            successor = getMin(root.right);
        }
        return successor;
    }
    
    TreeNode getMin(TreeNode p){
        while(p != null && p.left != null){
            p = p.left;
        }
        return p;
    }
}