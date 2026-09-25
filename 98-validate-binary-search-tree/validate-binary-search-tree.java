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
    boolean ans = true;
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        fun(root);
        return ans;
    }

    void fun(TreeNode root) {
        if (root == null) {
            return;
        }

        // Left
        fun(root.left);

        // Current
        if (prev == null) {
            prev = root;
        } else {
            if (root.val <= prev.val) {
                ans = false;
                return;
            }

            prev = root;
        }

        // Right
        fun(root.right);
    }
}