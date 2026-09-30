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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // Both nodes are absent, so they are symmetric.
        if (left == null && right == null) {
            return true;
        }

        // Exactly one node is absent.
        if (left == null || right == null) {
            return false;
        }

        // Values must match.
        if (left.val != right.val) {
            return false;
        }

        // Compare opposite children.
        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}