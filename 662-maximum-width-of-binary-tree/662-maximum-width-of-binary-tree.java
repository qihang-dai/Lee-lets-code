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
    class Pair{
        TreeNode node;
        int id;
        public Pair(TreeNode node, int id){
            this.node = node;
            this.id = id;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(root, 1));
        int res = 0;
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int width = 0;
            depth++; 
            boolean flag = false;
            int start = 0;
            int end = 0;
            for(int i = 0; i < size; i++){
                Pair cur = q.poll();
                int id = cur.id;
                TreeNode node = cur.node;
                if(i == 0) 
                    start = id;
                if(i == size - 1){
                    end = id;
                }
                if(node.left != null){
                    q.add(new Pair(node.left, 2 * id));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, 2 * id + 1));
                }
                
                
            }
            res = Math.max(end - start + 1, res);
        }
        
        return res;
        
    }
}