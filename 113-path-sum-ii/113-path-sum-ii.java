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
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }
    
    public void dfs(TreeNode root, int target){
        if(root == null) return;
        if(target == root.val && root.left == null && root.right == null){
            path.add(root.val);
            res.add(new ArrayList(path));
            path.removeLast();
            return;
        }
        path.add(root.val);
        dfs(root.left, target - root.val);
        path.removeLast();
        path.add(root.val);
        dfs(root.right, target - root.val);
        path.removeLast();
    }
}