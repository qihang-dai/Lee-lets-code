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
class Solution
{
    int minDepth= Integer.MAX_VALUE;//identity of minimum//global
    public int minDepth(TreeNode root) 
    {
        if(root == null)//base case when we are provide with a null graph 
            return 0;
        depthCal(root, 1);//it calculates the min depth on the basis of node 
        return minDepth;
    }
    public int depthCal(TreeNode root, int height)
    {//we are using the postorder traversal(LEFT RIGHT ROOT) because we want to know the child information first and then the parent informaion 
        if(root == null)//base case when we reach to null node, we return 0
            return 0;
        
        int left= depthCal(root.left, height + 1);//traversing down the left subtree and parallelly calulating the height//knowing about the left child //LEFT
        int right= depthCal(root.right, height + 1);//traversing down the right subtree and parallelly calulating the height//knowing about the right child //RIGHT
         
        //ROOT
        if(root.left == null && root.right == null)//calculating the minimum depth//leaf node
            minDepth= Math.min(minDepth, height);//comparing with previous depth and updating 
        
        return 1;//returmning the currnt height 
    }}