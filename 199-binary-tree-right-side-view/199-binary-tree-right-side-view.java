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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        Queue<TreeNode> q = new ArrayDeque();
        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode last = q.peek();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.right != null){
                    q.add(cur.right);
                }
                if(cur.left != null){
                    q.add(cur.left);
                }

            }
            res.add(last.val);
            
        }
        return res;
        
    }
}