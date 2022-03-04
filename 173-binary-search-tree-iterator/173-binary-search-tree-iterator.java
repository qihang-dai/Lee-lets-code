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
class BSTIterator {
    private Stack<TreeNode> stack;
    
    public void pushToleft(TreeNode p){
        while(p!=null){
            stack.push(p);
            p = p.left;
        }
    }
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        pushToleft(root);
    }
    
    public int next() {
        TreeNode cur = stack.pop();
        pushToleft(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */