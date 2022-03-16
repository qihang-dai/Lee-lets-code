/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String sp = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb  = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }
    
    public void serialize(StringBuilder sb, TreeNode root){
        if(root == null) return;
        sb.append(root.val).append(sp);
        serialize(sb, root.left);
        serialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        
        LinkedList<Integer> node = new LinkedList();
        for(String s : data.split(sp)){
            node.add(Integer.valueOf(s));
        }
        return deserialize(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    
    public TreeNode deserialize(LinkedList<Integer> node, int min, int max){
        if(node.isEmpty()) return null;
        int rootVal = node.getFirst();
        if(rootVal > max || rootVal < min){
            return null;
        }
        node.removeFirst();
        TreeNode root = new TreeNode(rootVal);
        root.left = deserialize(node, min, rootVal);
        root.right = deserialize(node, rootVal, max);
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;