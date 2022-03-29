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
    HashMap<Integer,Integer> map = new HashMap();
    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        int max = 0;
        for(int i : map.values()){
            max = Math.max(i, max);
        }
        
        List<Integer> res = new ArrayList();
        for(int i : map.keySet()){
            if(map.get(i) == max)
                res.add(i);
        }
        
        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            arr[i] = res.get(i);
        return arr;
        
    }
    
    public int sum(TreeNode root){
        if(root == null)
            return 0;
        int res =  root.val + sum(root.left) + sum(root.right);
        map.put(res, map.getOrDefault(res, 0) + 1);
        return res;
    }
}