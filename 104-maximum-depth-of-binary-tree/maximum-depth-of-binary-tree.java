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
    public int maxDepth(TreeNode root) {

        return maxHeight(root);
    }
    public int maxHeight(TreeNode root){
        if(root == null) return 0;
        int leftH = maxHeight(root.left);
        int rightH = maxHeight(root.right);
        return Math.max(leftH, rightH)+1;
    }
}