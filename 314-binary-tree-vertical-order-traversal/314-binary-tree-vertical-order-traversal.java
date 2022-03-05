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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        
        Map<Integer, List<Integer>> map = new HashMap();
        Queue<TreeNode> q = new ArrayDeque();
        Queue<Integer> cols = new ArrayDeque();
        
        int col = 0;
        q.add(root);
        cols.add(col);
        int min = 0;
        int max = 0;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            col = cols.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(cur.val);
            min = Math.min(col, min);
            max = Math.max(col, max);
            if(cur.left != null){
                q.add(cur.left);
                cols.add(col - 1);
            }

            if(cur.right != null){
                q.add(cur.right);
                cols.add(col + 1);
            }

        }
        
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
        
    }
}